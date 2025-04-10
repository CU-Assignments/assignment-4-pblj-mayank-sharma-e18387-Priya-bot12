class TicketCounter {
    private int totalSeats = 5;  // Total available seats

    public synchronized void bookTicket(String customerName, int numberOfSeats) {
        if (numberOfSeats <= totalSeats) {
            System.out.println(customerName + " is booking " + numberOfSeats + " seat(s)...");
            try {
                Thread.sleep(1000); // Simulate booking time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalSeats -= numberOfSeats;
            System.out.println("✅ Booking successful for " + customerName + ". Seats left: " + totalSeats);
        } else {
            System.out.println("❌ Sorry " + customerName + ", not enough seats. Seats left: " + totalSeats);
        }
    }
}

class BookingThread extends Thread {
    private TicketCounter counter;
    private String customerName;
    private int seatsToBook;

    public BookingThread(TicketCounter counter, String customerName, int seatsToBook) {
        this.counter = counter;
        this.customerName = customerName;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        counter.bookTicket(customerName, seatsToBook);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        // Create VIP bookings (higher priority)
        BookingThread vip1 = new BookingThread(counter, "👑 VIP - Alice", 2);
        BookingThread vip2 = new BookingThread(counter, "👑 VIP - Bob", 1);

        // Create regular bookings
        BookingThread regular1 = new BookingThread(counter, "User - Charlie", 2);
        BookingThread regular2 = new BookingThread(counter, "User - Diana", 1);

        // Set priorities (Thread.MAX_PRIORITY = 10, Thread.MIN_PRIORITY = 1)
        vip1.setPriority(Thread.MAX_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY);
        regular1.setPriority(Thread.NORM_PRIORITY);
        regular2.setPriority(Thread.NORM_PRIORITY);

        // Start all threads
        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
    }
}
