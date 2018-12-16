package com.felix.facade;

import java.util.List;

/**
 * The facade interface.
 *
 * @author Felix
 */
public interface IFacade {
    /**
     * Print the stage.
     */
    void show();

    /**
     * Sail with tigers.
     *
     * @param tigerNames tiger names.
     */
    void sail(List<String> tigerNames);
}
