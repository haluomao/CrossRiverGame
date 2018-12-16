package com.felix.observer;

import com.felix.builder.IRegion;
import com.felix.builder.Tiger;

/**
 * The abstract observer with default empty implement.
 *
 * @author Felix
 */
public abstract class AbstractObserver implements IObserver {
    public void handleNotReady() {
        // Leave the function body empty for some lazy observers.
    }

    public void handleNotSafe() {

    }

    public void handleDone() {

    }

    public void handleAccident(Tiger inDangerTiger, IRegion region) {

    }
}
