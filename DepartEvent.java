class DepartEvent extends Event {
    private final Customer customer;

    public DepartEvent(Customer customer) {
        super(customer.getDeparture());
        this.customer = customer;
    }

    @Override 
    public String toString() {
        return super.toString() + String.format(": %s departed", this.customer.toString());
    }

    @Override
    public Event[] simulate() {
        return new Event[] {};
    }
}