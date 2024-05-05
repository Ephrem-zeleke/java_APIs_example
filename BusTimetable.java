import kong.unirest.Unirest;

public class BusTimetable {
    public static void main(String[] args) {

        // assign a variable for the url

        String busTimeUrl = "https://svc.metrotransit.org/NexTrip/17940?format=json";
        // here now we can request the API

        Bus[] buses = Unirest.get(busTimeUrl).asObject(Bus[].class).getBody(); // since we are expecting an array
        // now we can loop over buses
        // we can print it in table format
        System.out.printf("%-10s %-40s %-20s\n", "Route", "Description", "Arrival Time");
        for (Bus bus: buses){
            System.out.printf("%-10s %-40s %-20s", bus.Route, bus.Description, bus.DepartureText);
        }


    }
}
// let's create a bus object that contain a description from the Array
// the response from the api is an array format but it contains an object about each bus

class Bus{

    public String DepartureText; // the character must much with the response from the APIs
    public String Route;
    public String Description;

}