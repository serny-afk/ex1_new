class StartService extends Event {
    private final Customer customer;
    private final Counter counter;
  
    public StartService(Customer customer, Counter counter) {
        super(customer.getArrival());
        this.customer = customer;
        this.counter = counter;
    }
    @Override
    public String toString() {
        return super.toString() + ": " + this.customer.toString() 
        + String.format(" service begin (by %s)", this.counter.toString());
    }

    @Override
    public Event[] simulate() {
        this.counter.setAvailability(false);
        return new Event[] {
            new EndService(this.customer, this.counter)
        };
    }
}