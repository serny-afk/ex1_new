class Counter{
    private final int id;
    private boolean isAvailable;

    public Counter(int id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Counter" + this.id;
    }
}