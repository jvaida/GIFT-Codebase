/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.lms.impl.common;

/**
 * Represents an exception with an invalid student identifier in the LMS
 * 
 * @author mhoffman
 *
 */
public class LmsInvalidStudentIdException extends LmsException {	

	private static final long serialVersionUID = 1L;

	public LmsInvalidStudentIdException(String msg, Throwable cause) {
		super(msg, cause);
	}
}