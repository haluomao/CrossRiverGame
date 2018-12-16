package com.felix.builder;

/**
 * Region interface.
 *
 * @author Felix
 */
public interface IRegion {
    /**
     * Get region name.
     * @return region name.
     */
    String getName();

    /**
     * The tiger leaves from region.
     * @param tiger a tiger.
     */
    void leave(Tiger tiger);

    /**
     * A tiger comes to region.
     * @param tiger a tiger.
     */
    void come(Tiger tiger);

    /**
     * Clear stage (off boat) for next action.
     */
    void clear();
}
