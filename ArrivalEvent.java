class ArrivalEvent extends Event {

    private final Customer customer;
    private final Counter[] counter; 

    public ArrivalEvent(Customer customer, Counter[] counter) {
        super(customer.getArrival());
        this.customer = customer;
        this.counter = counter;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(": %s arrives", this.customer.toString());
    }
    
    @Override
    public Event[] simulate() {
        for (Counter i : this.counter) {
            if (i.isAvailable()) {
                return new Event[] {
                    new StartService(this.customer, i)
                };                                
            }
        }       

        return new Event[] {
            new DepartEvent(this.customer)
        };
    }
}