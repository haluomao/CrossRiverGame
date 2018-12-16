package com.felix.observer;

import com.felix.builder.Region;
import com.felix.builder.Tiger;

/**
 * The subject interface.
 *
 * @author Felix
 */
public interface ISubject {
    /**
     * Register an observer.
     *
     * @param observer an observer.
     */
    void registerObserver(IObserver observer);

    /**
     * Remove an observer.
     * @param observer an observer.
     */
    void removeObserver(IObserver observer);

    /**
     * Notify not ready event to all observers.
     */
    void notifyNotReady();

    /**
     * Notify done event to all observers.
     */
    void notifyDone();

    /**
     * Notify not safe event to all observers.(just for extension)
     */
    void notifyNotSafe();

    /**
     * Notify accident event to all observers.
     *
     * @param tiger The injured tiger.
     * @param region The region of crime scene.
     */
    void notifyAccident(Tiger tiger, Region region);
}
