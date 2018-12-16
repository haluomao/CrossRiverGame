package com.felix.builder;

import java.util.List;

/**
 * The boat.
 *
 * @author Felix
 */
public class Boat extends Region {

    public static final class Builder {
        private String name;
        private Position position;
        private List<Tiger> tigerList;

        private Builder() {
        }

        public static Builder aBoat() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPosition(Position position) {
            this.position = position;
            return this;
        }

        public Builder withTigerList(List<Tiger> tigerList) {
            this.tigerList = tigerList;
            return this;
        }

        public Boat build() {
            Boat region = new Boat();
            region.setName(name);
            region.setPosition(position);
            region.setTigerList(tigerList);
            return region;
        }
    }

    public Boat clone() {
        return this;
    }
}
