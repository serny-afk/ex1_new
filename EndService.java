class EndService extends Event {
    private final Customer customer;
    private final Counter counter;
    
    public EndService(Customer customer, Counter counter) {
        super(customer.getDeparture());
        this.customer = customer;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + this.customer.toString() 
        + String.format(" service done (by %s)", this.counter.toString());
    }

    @Override 
    public Event[] simulate() {
        this.counter.setAvailability(true);
        return new Event[] {
            new DepartEvent(this.customer)
        };
    }
}