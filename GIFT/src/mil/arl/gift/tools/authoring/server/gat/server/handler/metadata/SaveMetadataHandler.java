/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.tools.authoring.server.gat.server.handler.metadata;

import generated.metadata.Metadata;
import mil.arl.gift.common.metrics.MetricsSenderSingleton;
import mil.arl.gift.common.io.AbstractSchemaHandler;
import mil.arl.gift.common.io.DetailedException;
import mil.arl.gift.tools.authoring.common.util.CommonUtil;
import mil.arl.gift.tools.authoring.server.gat.shared.action.SaveJaxbObjectResult;
import mil.arl.gift.tools.authoring.server.gat.shared.action.metadata.SaveMetadata;
import mil.arl.gift.tools.services.ServicesManager;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * ActionHandler for actions of type SaveMetadata.
 */ 
public class SaveMetadataHandler implements ActionHandler<SaveMetadata, SaveJaxbObjectResult> {

    /**  instance of the logger. */
    private static Logger logger = LoggerFactory.getLogger(SaveMetadataHandler.class);
    
    /* (non-Javadoc)
     * @see net.customware.gwt.dispatch.server.ActionHandler#getActionType()
     */
    @Override
    public Class<SaveMetadata> getActionType() {
        return SaveMetadata.class;
    }

    /* (non-Javadoc)
     * @see net.customware.gwt.dispatch.server.ActionHandler#execute(net.customware.gwt.dispatch.shared.Action, net.customware.gwt.dispatch.server.ExecutionContext)
     */
    @Override
    public synchronized SaveJaxbObjectResult execute(SaveMetadata action, ExecutionContext context ) {
        long start = System.currentTimeMillis();
        
        if(logger.isInfoEnabled()){
            logger.info("Attempting to save metadata jaxb object : "+action);
        }
        
        //If the acquire flag is set to true then we're in one of two cases:
	    //1.) We're writing a brand new file that doesn't exist yet.
	    //2.) We're overwriting a file via the Save-As functionality.
	    //Case 1 is no problem but in case 2 we can only proceed if nobody
	    //else has a lock on the file we're overwriting. So lets check for
	    //the failure condition of case 2.
        String relativePath = action.getRelativePath();
	    boolean acquireInsteadOfRenew = action.isAcquireLockInsteadOfRenew();
		String userName = action.getUserName();
	    Metadata metadata = action.getMetadata();

	    try{
		    if(acquireInsteadOfRenew && ServicesManager.getInstance().getFileServices().isLockedFile(userName, relativePath)) {
		    	SaveJaxbObjectResult result = new SaveJaxbObjectResult();
		    	result.setSuccess(false);
		    	result.setErrorMsg("Unable to write/marshall Metadata object to '" + relativePath + "' because that file already exists and it is presently locked.");
		    	return result;
		    }
	    } catch (DetailedException e){
	    	
	    	SaveJaxbObjectResult result = new SaveJaxbObjectResult();
	    	result.setSuccess(false);
	    	result.setErrorMsg("An error occurred while attempting to check if '" + relativePath + "' is locked. " + e.getReason());
	    	result.setErrorDetails(e.getDetails());
	    	result.setErrorStackTrace(DetailedException.getFullStackTrace(e));
	    	return result;
	    } catch (Exception e){
	    	
	    	SaveJaxbObjectResult result = new SaveJaxbObjectResult();
	    	result.setSuccess(false);
	    	result.setErrorMsg("An error occurred while attempting to check if '" + relativePath + "' is locked.");
	    	result.setErrorDetails(e.toString());
	    	result.setErrorStackTrace(DetailedException.getFullStackTrace(e));
	    	return result;
	    }
	    
	    //TODO Without a more sophisticated multi-threaded solution there is a SLIGHT
	    //possibility that somebody else will lock the file right now. That would
	    //of course throw a real wrench into things.
        
        //We have to update the version number every time we save the file. I
	    //would have done this on the client side but the "common" code that
	    //handles the version logic isn't accessible on the client side.
  		String currentVersion = metadata.getVersion();
  		String schemaVersion = CommonUtil.getSchemaVersion(AbstractSchemaHandler.METADATA_SCHEMA_FILE);
  		String newVersion = CommonUtil.generateVersionAttribute(currentVersion, schemaVersion);
  		metadata.setVersion(newVersion);
    	
  		boolean schemaValid;
    	try {
    		schemaValid = ServicesManager.getInstance().getFileServices().marshalToFile(userName, metadata, relativePath, null);
    	} catch(DetailedException e) {
    		logger.error("Unable to write/marshall Metadata object to '" + relativePath + "'.", e);
			
    		SaveJaxbObjectResult result = new SaveJaxbObjectResult();
			result.setSuccess(false);
    		result.setErrorMsg("Unable to write/marshall Metadata object to '" + relativePath + "'. " + e.getReason());
    		result.setErrorDetails(e.getDetails());
	    	result.setErrorStackTrace(DetailedException.getFullStackTrace(e));
    		return result;
    		
    	} catch(Exception e) {
    		logger.error("Unable to write/marshall Metadata object to '" + relativePath + "'.", e);
			
    		SaveJaxbObjectResult result = new SaveJaxbObjectResult();
			result.setSuccess(false);
    		result.setErrorMsg("Unable to write/marshall Metadata object to '" + relativePath + "'. ");
    		result.setErrorDetails(e.toString());
	    	result.setErrorStackTrace(DetailedException.getFullStackTrace(e));
    		return result;
    	}
    	
	    //Return success!
	    SaveJaxbObjectResult result = new SaveJaxbObjectResult();
    	result.setNewVersion(newVersion);
    	result.setSchemaValid(schemaValid);
    	MetricsSenderSingleton.getInstance().endTrackingRpc("metadata.SaveMetadata", start);
		return result;
    }

    /* (non-Javadoc)
     * @see net.customware.gwt.dispatch.server.ActionHandler#rollback(net.customware.gwt.dispatch.shared.Action, net.customware.gwt.dispatch.shared.Result, net.customware.gwt.dispatch.server.ExecutionContext)
     */
    @Override
    public synchronized void rollback(SaveMetadata action, SaveJaxbObjectResult result, ExecutionContext context ) 
            throws ActionException {
    }
}