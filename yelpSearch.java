import kong.unirest.Unirest;

import java.util.Map;
import java.util.Objects;

public class yelpSearch {
    public static void main(String[] args) {

        String yelpUrl = "https://api.yelp.com/v3/businesses/search";
        String YELP_API_KEY = "TqaCPhO2zSLmi9wLxTl8_JNyf6mbMqJ6a0uMgrNMb96RS_CIF5gQ7Y6G97i0RrD4kXnj5r7EieOiQYATridcRGv0cpXhiqC5dL_aOzw9YsVmJ-7yk9yl8E7F6341ZnYx";

        Map<String, Object> yelpQuery = Map.of(
                "term", "pizza",
                "location", "Minneapolis, MN",
                "categories", "restaurants",
                "price", "1");

        yelpResponse response = Unirest.get(yelpUrl).header(
                "Authorization", "Bearer " + YELP_API_KEY).
                queryString(yelpQuery).
                asObject(yelpResponse.class).getBody();

        System.out.println(response);

        for (Business b:response.businesses){
            System.out.println(b.name);
        }



    }
}
