package com.felix.builder;

/**
 * The Tiger.
 *
 * @author Felix
 */
public class Tiger {

    public static final class Builder {
        private String name;
        private SIZE size;
        private boolean canBoat;
        private Tiger parent;

        private Builder() {
        }

        public static Builder aTiger() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSize(SIZE size) {
            this.size = size;
            return this;
        }

        public Builder withCanBoat(boolean canBoat) {
            this.canBoat = canBoat;
            return this;
        }

        public Builder withParent(Tiger parent) {
            this.parent = parent;
            return this;
        }

        public Tiger build() {
            Tiger tiger = new Tiger();
            tiger.setName(name);
            tiger.setSize(size);
            tiger.setCanSail(canBoat);
            tiger.setParent(parent);
            return tiger;
        }
    }

    public enum SIZE {
        LARGE, SMALL
    }

    private String name;
    private SIZE size;
    private boolean canSail;
    private Tiger parent;

    public boolean canAttack() {
        return size == SIZE.LARGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }

    public boolean isCanSail() {
        return canSail;
    }

    public void setCanSail(boolean canSail) {
        this.canSail = canSail;
    }

    public Tiger getParent() {
        return parent;
    }

    public void setParent(Tiger parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Tiger{");
        builder.append("name=");
        builder.append(name);
        builder.append(", size=");
        builder.append(size);
        builder.append(", canSail=");
        builder.append(canSail);
        builder.append(", parent=");
        builder.append(parent);
        builder.append('}');
        return builder.toString();
    }
}
