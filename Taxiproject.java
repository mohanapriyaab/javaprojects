import java.util.*;

class Taxi {
    private int id;
    private String location;
    private boolean isBooked;

    public Taxi(int id, String location) {
        this.id = id;
        this.location = location;
        this.isBooked = false;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookTaxi() {
        isBooked = true;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }
}

class TaxiService {
    private List<Taxi> taxis = new ArrayList<>();

    public void addTaxi(Taxi taxi) {
        taxis.add(taxi);
    }

    public void showAvailableTaxis(String userLocation) {
        boolean found = false;
        System.out.println("\nNearby Available Taxis:");
        for (Taxi taxi : taxis) {
            if (taxi.getLocation().equalsIgnoreCase(userLocation)) {
                if (!taxi.isBooked()) {
                    System.out.println("Taxi ID: " + taxi.getId() + " | Location: " + taxi.getLocation());
                    found = true;
                } else {
                    System.out.println("Taxi ID: " + taxi.getId() + " - Already Booked!");
                }
            }
        }
        if (!found) {
            System.out.println("No available taxis at your location.");
        }
    }

    public boolean bookTaxiById(int taxiId) {
        for (Taxi taxi : taxis) {
            if (taxi.getId() == taxiId) {
                if (!taxi.isBooked()) {
                    taxi.bookTaxi();
                    return true;
                } else {
                    return false; 
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaxiService service = new TaxiService();

       
        service.addTaxi(new Taxi(1, "Anna Nagar"));
        service.addTaxi(new Taxi(2, "Velachery"));
        service.addTaxi(new Taxi(3, "Anna Nagar"));
        service.addTaxi(new Taxi(4, "T Nagar"));

        System.out.println("Welcome to Taxi Booking App 🚖");

        System.out.print("\nEnter your location: ");
        String userLocation = sc.nextLine();

        service.showAvailableTaxis(userLocation);

        System.out.print("\nEnter Taxi ID to book: ");
        int taxiId = sc.nextInt();

        if (service.bookTaxiById(taxiId)) {
            System.out.println("Taxi booked successfully! 🚖✅");
        } else {
            System.out.println("Sorry, Taxi already booked or Invalid Taxi ID! ❌");
        }

        
        service.showAvailableTaxis(userLocation);
    }
}
