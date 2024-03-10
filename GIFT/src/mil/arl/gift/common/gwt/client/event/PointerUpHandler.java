/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.common.gwt.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for {@link PointerUpEvent} events.
 * 
 * @author nroberts
 */
public interface PointerUpHandler extends EventHandler{
    
    /**
     * Called when a native pointer up event (i.e. "onpointerup") is fired
     * 
     * @param event the {@link PointerUpEvent} that was fired
     */
    void onPointerUp(PointerUpEvent event);
}
