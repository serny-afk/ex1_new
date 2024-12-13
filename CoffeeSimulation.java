import java.util.Scanner;

/**
 * This class implements a coffee shop simulation.
 *
 * @author dcsaysp
 * @version CS2030S AY24/25 Semester 1
 */ 
class CoffeeSimulation extends Simulation {
  /** 
   * The availability of counters in the coffee shop. 
   */
  public boolean[] available;

  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  public Event[] initEvents;

  /** 
   * Constructor for a coffee shop simulation. 
   *
   * @param sc A scanner to read the parameters from.  The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a 
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
  public CoffeeSimulation(Scanner sc) {
    initEvents = new Event[sc.nextInt()];
    int numOfCounters = sc.nextInt();

    //copied this part
    Counter[] counters = new Counter[numOfCounters];
    for (int i = 0; i < numOfCounters; i++) {
      counters[i] = new Counter(i, true);
    }

    // available = new boolean[numOfCounters];
    // for (int i = 0; i < numOfCounters; i++) {
    //   available[i] = true;
    // }

    int id = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();      

      // commented out since CoffeeEvent made abstract
      // initEvents[id] = new CoffeeEvent(CoffeeEvent.ARRIVAL, 
      //     arrivalTime, id, serviceTime, available);
      
      // copied this part also
      Customer customer = new Customer(id, arrivalTime, serviceTime);
      initEvents[id] = new ArrivalEvent(customer, counters);
      id += 1;
    }
  }

  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
