package com.felix.memento;

import com.felix.builder.Boat;
import com.felix.builder.Region;

/**
 * The memento to save initial stage.
 *
 * @author Felix
 */
public class Memento {
    private Boat boat;
    private Region south;
    private Region north;

    public Memento(Boat boat, Region south, Region north) {
        this.boat = boat;
        this.south = south;
        this.north = north;
    }

    public Region getSouth() {
        return south.clone();
    }

    public void setSouth(Region south) {
        this.south = south;
    }

    public Region getNorth() {
        return north.clone();
    }

    public void setNorth(Region north) {
        this.north = north;
    }

    public Boat getBoat() {
        return boat.clone();
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
