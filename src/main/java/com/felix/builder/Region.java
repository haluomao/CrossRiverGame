package com.felix.builder;

import java.util.List;

/**
 * The region.
 *
 * @author Felix
 */
public class Region implements IRegion {

    public static final class Builder {
        private String name;
        private Position position;
        private List<Tiger> tigerList;

        private Builder() {
        }

        public static Builder aRegion() {
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

        public Region build() {
            Region region = new Region();
            region.setName(name);
            region.setPosition(position);
            region.setTigerList(tigerList);
            return region;
        }
    }

    public enum Position {
        NORTH, SOUTH
    }

    private String name;
    private Position position;
    private List<Tiger> tigerList;

    public Region clone() {
        return this;
    }

    public void leave(Tiger tiger) {
        tigerList.remove(tiger);
    }

    public void come(Tiger tiger) {
        tigerList.add(tiger);
    }

    public void clear() {
        tigerList.clear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Tiger> getTigerList() {
        return tigerList;
    }

    public void setTigerList(List<Tiger> tigerList) {
        this.tigerList = tigerList;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Region{");
        builder.append("name=");
        builder.append(name);
        builder.append(", position=");
        builder.append(position);
        builder.append(", tigerList=");
        builder.append(tigerList);
        builder.append('}');
        return builder.toString();
    }
}
