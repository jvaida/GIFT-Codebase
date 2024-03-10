package mil.arl.gift.gateway.interop.myplugin;

import generated.course.MyPluginInputs;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.arl.gift.common.ConfigurationException;
import mil.arl.gift.common.Siman;
import mil.arl.gift.common.enums.MessageTypeEnum;
import mil.arl.gift.common.enums.SimanTypeEnum;
import mil.arl.gift.common.enums.TrainingApplicationEnum;
import mil.arl.gift.common.io.DetailedException;
import mil.arl.gift.common.ta.state.SimpleExampleState;
import mil.arl.gift.common.ta.state.StopFreeze;
import mil.arl.gift.common.ta.state.TrainingAppState;
import mil.arl.gift.gateway.GatewayModule;
import mil.arl.gift.gateway.interop.AbstractInteropInterface;
import mil.arl.gift.net.api.message.Message;
import mil.arl.gift.net.xmlrpc.XMLRPCClient;
import mil.arl.gift.net.xmlrpc.XMLRPCServer;

public class MyPluginInterface extends AbstractInteropInterface {
    
    /** Instance of the logger */
    private static Logger logger = LoggerFactory.getLogger(MyPluginInterface.class);

    /**
     * contains the types of GIFT messages this interop interface can translate and handle or send
     * on to the training application
     */
    private static List<MessageTypeEnum> supportedMsgTypes;   
    static{
        supportedMsgTypes = new ArrayList<MessageTypeEnum>();
        supportedMsgTypes.add(MessageTypeEnum.SIMAN);
        supportedMsgTypes.add(MessageTypeEnum.DISPLAY_FEEDBACK_GATEWAY_REQUEST);
    }

    @Override
    public List<MessageTypeEnum> getSupportedMessageTypes() {
        return supportedMsgTypes;
    }

    @Override
    public void setEnabled(boolean value){

        boolean isEnabledAlready = isEnabled();
        super.setEnabled(value);

        if(!isEnabledAlready){

            //listen for RPC requests
            try {
                server.start();
            } catch (IOException e) {
                logger.error("Caught exception when trying to start the RPC server.", e);
                throw new RuntimeException("There was a problem starting the RPC server.");
            }

            logger.info("Started listening for incoming training application messages.");

        }else{

            //stop listening for RPC requests
            server.stop();

            logger.info("Stopped listening for incoming training application messages.");
        }
    }

    @Override
    public boolean configure(Serializable config) {

        if (config instanceof generated.gateway.XMLRPC) {

            generated.gateway.XMLRPC pluginConfig = (generated.gateway.XMLRPC) config;
            try {
                server = new XMLRPCServer(pluginConfig.getServerNetworkPort(), MyPluginXMLRPC.class);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                client = new XMLRPCClient(pluginConfig.getExternalServerNetworkAddress(), pluginConfig.getExternalServerNetworkPort());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            throw new ConfigurationException(getName()+" Plugin interface can't configure.",getName()+" Plugin interface can't configure using interop config instance of " + config, null);
        }

        return false;
    }

    @Override
    public void cleanup() {
        server.stop();
    }

    /**
     * The XML RPC server created by this class to allow the training application to remotely call methods
     * in this class, mainly the 'handleTrainingApplicationMessage' method.
     */
    private XMLRPCServer server;

    /**
     * The XML RPC client created by this class to call remote methods in the training application C# program which
     * is hosting an XML RPC server.
     */
    private XMLRPCClient client;

    /** needed for XML-RPC called methods that will need to send messages via the Gateway module */
    private static MyPluginInterface instance = null;

    /**
     * This inner class contains the RPC methods the training application RPC client can call.
     * The only reason I choose not to use the outer class of SimpleExamplePluginTAPluginInterface was to prevent having
     * to create another constructor (as mentioned in the Notes below) and to organize the RPC methods
     * together instead of possible exposing other methods in ExamplePLuginInterface.
     *
     * Notes:
     * 1) This class must contain either no class constructor OR an empty constructor.
     * 2) Every RPC method must return a non-null, non-void, non java.lang.Object value (e.g. Integer).
     * 3) if using an inner class, the class must be static
     * 
     * @author mhoffman
     *
     */
    public static class MyPluginXMLRPC{

        /**
         * This is a RPC method hosted by the RPC server in this class and called by the
         * training application's RPC client to handle 'game state' messages.
         *
         * XML-RPC method name =
         *  "mil.arl.gift.gateway.interop.simple.SimpleExampleTAPluginInterface$SimpleExampleTAPluginXMLRPC.handleTrainingApplicationMessage" 
         *
         * @param message the training application message content
         * @return Integer an arbitrary return object to satisfy the XML-RPC library requirements
         */
        public Integer handleTrainingApplicationMessage(String message){

            SimpleExampleState exampleState = new SimpleExampleState(message);
            sendMessageToGIFT(exampleState, MessageTypeEnum.SIMPLE_EXAMPLE_STATE);  

            return XMLRPCServer.EMPTY_RETURN_OBJECT;
        }

        /**
         * This is a RPC method hosted by the RPC server in this class and called by the
         * training application's RPC client to notify GIFT that the TA is finished.
         *
         * XML-RPC method name =
         *  "mil.arl.gift.gateway.interop.simple.SimpleExampleTAPluginInterface$SimpleExampleTAPluginXMLRPC.handleTrainingApplicationFinished" 
         *
         * @return Integer an arbitrary return object to satisfy the XML-RPC library requirements
         */
        public Integer handleTrainingApplicationFinished(){

            StopFreeze stopFreeze = new StopFreeze(0, 0, 0, 0);
            sendMessageToGIFT(stopFreeze, MessageTypeEnum.STOP_FREEZE);  

            return XMLRPCServer.EMPTY_RETURN_OBJECT;
        }
    }

    private static List<TrainingApplicationEnum> REQ_TRAINING_APPS;
    static{
        REQ_TRAINING_APPS = new ArrayList<TrainingApplicationEnum>();
        REQ_TRAINING_APPS.add(TrainingApplicationEnum.SIMPLE_EXAMPLE_TA);
    }

    @Override
    public List<TrainingApplicationEnum> getReqTrainingAppConfigurations(){
        return REQ_TRAINING_APPS;
    }

     /**
     * Class constructor
     *
     * @param name - the display name of the plugin
     */
    public MyPluginInterface(String name){
        super(name, true);

        instance = this;
    }

    /**
     * Call upon the Gateway module to construct and then send a new GIFT message using the payload
     * provided.
     *
     * @param payload the contents of the message to send
     * @param messageTypeEnum the enumerated type of the message
     */
    private static void sendMessageToGIFT(Object payload, MessageTypeEnum messageTypeEnum){       
        GatewayModule.getInstance().sendMessageToGIFT((TrainingAppState) payload, messageTypeEnum, instance);
    }

    /**
     * Call a remote method with the given parameter.
     *
     * @param rpcMethodName the name of the method to call on the RPC server
     * @param param the single parameter to pass to the rpcMethod.  Can be null.
     * @param errorMsg - used to append error content too, if an error occurs
     * @return Object the return value of the remote method.  Can be null.
     */   
    private Object callRPCMethod(String rpcMethodName, String param, StringBuilder errorMsg) {

        Vector<String> params = new Vector<>(1);
        if(params != null){
            params.addElement(param);
        }

        return callRPCMethod(rpcMethodName, params, errorMsg);
    }

    /**
     * Call a remote method with the given parameters.
     *
     * @param rpcMethodName the name of the method to call on the RPC server
     * @param params the parameters to pass to the rpcMethod.  Can be null.
     * @param errorMsg - used to append error content too, if an error occurs
     * @return Object the return value of the remote method.  Can be null.
     */   
    private Object callRPCMethod(String rpcMethodName, Vector<?> params, StringBuilder errorMsg) {

        try {
            Object returnObj = client.callMethod(rpcMethodName, params);
            return returnObj;
        } catch (XmlRpcException e) {
            logger.error("There was an exception thrown when calling the RPC method of "+rpcMethodName+".", e);
            errorMsg.append("Failed to call RPC method named "+rpcMethodName+".");
        }

        return null;
    }    


    @Override
    public boolean handleGIFTMessage(Message message, StringBuilder errorMsg) {

        // Below is some arbitrary handling of GIFT messages.
        // In most instances your interop plugin will need to handle SIMAN messages in order to
        // allow GIFT to synchronize with the TA.
        // Look at the other interop plugins for more examples of handling GIFT messages.

        if (message.getMessageType() == MessageTypeEnum.SIMAN) {

            Siman siman = (Siman) message.getPayload();

            if (siman.getSimanTypeEnum() == SimanTypeEnum.LOAD) {

                generated.course.InteropInputs interopInputs = getLoadArgsByInteropImpl(this.getClass().getName(), siman.getLoadArgs());
                generated.course.SimpleExampleTAInteropInputs inputs = (generated.course.SimpleExampleTAInteropInputs) interopInputs.getInteropInput();

                generated.course.SimpleExampleTAInteropInputs.LoadArgs args = inputs.getLoadArgs();

                //actually calling a different RPC method here, called "load" to provide another example of an RPC method.
                Object returnObj = callRPCMethod("load", args.getScenarioName(), errorMsg);      
                logger.info("Receive return value of "+returnObj+" from XML-RPC call for method named 'load'.");

            }else if(siman.getSimanTypeEnum() == SimanTypeEnum.PAUSE){

                callRPCMethod("blob", "Pause message received", errorMsg);            

            }else if(siman.getSimanTypeEnum() == SimanTypeEnum.RESTART){

                callRPCMethod("blob", "Restart message received", errorMsg);

            }else if(siman.getSimanTypeEnum() == SimanTypeEnum.RESUME){

                callRPCMethod("blob", "Resume message received", errorMsg);

            }else if(siman.getSimanTypeEnum() == SimanTypeEnum.START){

                callRPCMethod("blob", "Start message received", errorMsg);

            }else if(siman.getSimanTypeEnum() == SimanTypeEnum.STOP){

                callRPCMethod("blob", "Stop message received", errorMsg);

            }else{
                errorMsg.append(getName()+" plugin can't handle siman type of "+siman.getSimanTypeEnum());
                logger.error("Found unhandled Siman type of "+siman.getSimanTypeEnum());
            }

        }else if(message.getMessageType() == MessageTypeEnum.DISPLAY_FEEDBACK_GATEWAY_REQUEST){           
            //send some feedback text to the example training application

            String text = (String)message.getPayload();
            callRPCMethod("blob", "Display Feedback received with feedback of \""+text+ "\"", errorMsg);

        }else{
            logger.error("Received unhandled GIFT message to send over to the "+getName()+" plugin, " + message);

            errorMsg.append(getName()+" plugin can't handle message of type "+message.getMessageType());
        }

        return false;
    }


    @Override
    public List<MessageTypeEnum> getProducedMessageTypes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProducedMessageTypes'");
    }

    @Override
    public Serializable getScenarios() throws DetailedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScenarios'");
    }

    @Override
    public Serializable getCurrentScenarioMetadata() throws DetailedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentScenarioMetadata'");
    }

    @Override
    public Serializable getSelectableObjects() throws DetailedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSelectableObjects'");
    }

    @Override
    public void selectObject(Serializable objectIdentifier) throws DetailedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectObject'");
    }

    @Override
    public void loadScenario(String scenarioIdentifier) throws DetailedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadScenario'");
    }

    @Override
    public File exportScenario(File exportFolder) throws DetailedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportScenario'");
    }
}
