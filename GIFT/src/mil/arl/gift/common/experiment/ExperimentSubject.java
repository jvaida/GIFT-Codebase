/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.common.experiment;

import java.io.Serializable;
import java.util.Date;

/**
 * An RPC-safe and client-safe representation of an experiment subject. This class exists to deal with common cases where 
 * {@link mil.arl.gift.ums.db.table.DbExperimentSubject DbExperimentSubject} cannot be used, such as in the Javascript generated by GWT for web clients 
 * or in remote procedure calls made between web clients and servers.
 * 
 * @author nroberts
 */
public class ExperimentSubject implements Serializable {

	private static final long serialVersionUID = -3449863746309592830L;
	
	/** The ID of this experiment subject*/
	private ExperimentSubjectId experimentSubjectId;

	/** times defined when a user started the course and when the course was ended */
    private Date startTime;
    private Date endTime;    
    
    /** the domain session message log file name (e.g. domainSession7_uId1_2015-08-21_15-13-17.log) */
    private String messageLogFilename;
    
    /**
     * Public no-arg constructor required by GWT RPC
     */
    public ExperimentSubject(){
    	
    }
    
    /**
     * Creates a new experiment subject
     * 
     * @param id the subject's ID
     * @param startTime time when the user started the experiment course
     * @param endTime time when the user ended the experiment course
     * @param messageLogFileName the domain session message log file name
     */
    public ExperimentSubject(ExperimentSubjectId id, Date startTime, Date endTime, String messageLogFileName){
    	
    	if(id == null){
    		throw new IllegalArgumentException("The experiment subject ID cannot be null.");
    	}
    	
    	this.experimentSubjectId = id;
    	
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.messageLogFilename = messageLogFileName;   	
    }
	 
	    
    /**
     * Sets this experiment subject's ID
     * 
     * @param experimentSubjectId the new ID
     */
    public void setExperimentSubjectId(ExperimentSubjectId experimentSubjectId){
        this.experimentSubjectId = experimentSubjectId;
    }
    
    /**
     * Gets this experiment subject's ID
     * 
     * @return the ID
     */
    public ExperimentSubjectId getExperimentSubjectId(){
        return experimentSubjectId;
    }

    /**
     * Gets the time when this subject started the experiment course
     * 
     * @return the start time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Sets the time when this subject started the experiment course
     * 
     * @param startTime the start time
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    /**
     * Gets the time when this subject ended the experiment course
     * 
     * @return the end time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Sets the time when this subject ended the experiment course
     * 
     * @param endTime the end time
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the subject's domain session message log file name
     * 
     * @return the log file name
     */
    public String getMessageLogFilename() {
        return messageLogFilename;
    }

    /**
     *
     * Gets the subject's domain session message log file name
     * 
     * @param messageLogFilename the log file name
     */
    public void setMessageLogFilename(String messageLogFilename) {
        this.messageLogFilename = messageLogFilename;
    }
    
    @Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[ExperimentSubject:");
		sb.append(" id = ").append(getExperimentSubjectId());
		sb.append(", startTime = ").append(getStartTime());
		sb.append(", endTime = ").append(getEndTime());
		sb.append(", messageLogFileName = ").append(getMessageLogFilename());
		sb.append("]");

		return sb.toString();
	}
}