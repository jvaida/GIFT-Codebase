/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.tutor.server;

/**
 * Callback interface for when a create user action has completed
 *
 * @author jleonard
 */
public interface GetUserIdAsyncResponseCallback {

    /**
     * Callback when a create user action has been completed
     * 
     * @param userId The user ID of the created user, 0 if none was created
     * @param success If the action was successful or not
     * @param response The result of the action
     */
    void notify(int userId, boolean success, String response);
}
