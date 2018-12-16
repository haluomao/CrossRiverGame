package com.felix.observer;

import com.felix.builder.IRegion;
import com.felix.builder.Tiger;

/**
 * The observer interface.
 *
 * @author Felix
 */
public interface IObserver {
    /**
     * Handle not ready stage.
     */
    void handleNotReady();

    /**
     * Handle not safe stage.
     */
    void handleNotSafe();

    /**
     * Handle done stage.
     */
    void handleDone();

    /**
     * Handle accident.
     *
     * @param inDangerTiger the tiger injured.
     * @param region the region of crime scene.
     */
    void handleAccident(Tiger inDangerTiger, IRegion region);
}
