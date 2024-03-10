/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.net.api.message;

import mil.arl.gift.common.UserSession;
import mil.arl.gift.common.enums.MessageTypeEnum;
import mil.arl.gift.common.enums.ModuleTypeEnum;

/**
 * This class represents a user session message.  It contains the minimal header information for GiFT, in addition
 * to the payload to be encoded/decoded and the learner's user id and domain session id.
 *
 * @author mhoffman
 *
 */
public class DomainSessionMessage extends UserSessionMessage implements DomainSessionMessageInterface {

    /** the unique domain session id for the current learner's domain session */
    private int domainSessionId;

    /**
     * Class constructor - creates a new message.
     * This constructor is used for creating new messages to send.
     *
     * @param messageType - the type of message
     * @param sourceEventId - the event id generated by the sender
     * @param senderModuleName - name of the module sending the message
     * @param senderAddress - the address of the sender
     * @param senderModuleType - type of module sending the message
     * @param destinationAddress - the destination for the message
     * @param payload - the payload of the message (i.e. not the header)
     * @param userSession - information about the user session (including the unique user id of the learner)
     *                      the message is associated with
     * @param domainSessionId - unique domain session id
     * @param needsACK - whether or not this message is expecting an ACK upon successful decoding at the destination
     */
    public DomainSessionMessage(MessageTypeEnum messageType, int sourceEventId, String senderModuleName,
            String senderAddress, ModuleTypeEnum senderModuleType, String destinationAddress, Object payload, UserSession userSession, int domainSessionId, boolean needsACK){
        super(messageType, sourceEventId, senderModuleName, senderAddress, senderModuleType, destinationAddress, payload, userSession, needsACK);

        this.domainSessionId = domainSessionId;
    }

    /**
     * Class constructor - used when decoding a message as the sequence number has already been created.
     *
     * @param messageType - the type of message
     * @param seqNum - the sequence number created by the sender
     * @param sourceEventId - the event id generated by the sender
     * @param timeStamp - the time at which the message was originally created
     * @param senderModuleName - name of the module sending the message
     * @param senderAddress - the address of the sender
     * @param senderModuleType - type of module sending the message
     * @param destinationAddress - the destination for the message
     * @param payload - the payload of the message (i.e. not the header)
     * @param userSession - information about the user session (including the unique user id of the learner)
     *                      the message is associated with
     * @param domainSessionId - unique domain session id
     * @param needsACK - whether or not this message is expecting an ACK upon successful decoding at the destination
     */
    public DomainSessionMessage(MessageTypeEnum messageType, int seqNum, int sourceEventId, long timeStamp, String senderModuleName,
            String senderAddress, ModuleTypeEnum senderModuleType, String destinationAddress, Object payload, UserSession userSession, int domainSessionId, boolean needsACK){
        super(messageType, seqNum, sourceEventId, timeStamp, senderModuleName, senderAddress, senderModuleType, destinationAddress, payload, userSession, needsACK);

        this.domainSessionId = domainSessionId;
    }

    @Override
    public int getDomainSessionId(){
        return domainSessionId;
    }

    @Override
    public Message copyNewDestination(String newDestinationAddress){

        Message message = new DomainSessionMessage(this.getMessageType(), this.getSourceEventId(), this.getSenderModuleName(), this.getSenderAddress(),
                this.getSenderModuleType(), newDestinationAddress, this.getPayload(), this.getUserSession(), this.getDomainSessionId(), this.needsHandlingResponse());

        if(isReplyMessage()){
            message.setReplyToSequenceNumber(getReplyToSequenceNumber());
        }

        return message;
    }
    
    /**
     * Creates a deep copy of this domain session message but with a new domain session id.
     * @param newDomainSessionId the new domain session id to use
     * @return the new domain session message with the new domain session id.
     */
    public DomainSessionMessage copyNewDomainSessionId(int newDomainSessionId){
        
        DomainSessionMessage message = new DomainSessionMessage(this.getMessageType(), this.getSourceEventId(), this.getSenderModuleName(), this.getSenderAddress(),
                this.getSenderModuleType(), this.getDestinationQueueName(), this.getPayload(), this.getUserSession(), newDomainSessionId, this.needsHandlingResponse());

        if(isReplyMessage()){
            message.setReplyToSequenceNumber(getReplyToSequenceNumber());
        }

        return message;
    }

    @Override
    public String toString(){

        StringBuffer sb = new StringBuffer();
        sb.append("[DomainSessionMessage: ");
        sb.append("domainSessionId = ").append(getDomainSessionId());
        sb.append(", ").append(super.toString());
        sb.append("]");

        return sb.toString();
    }
}