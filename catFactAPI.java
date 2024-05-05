import kong.unirest.Unirest;

public class catFactAPI {
    public static void main(String[] args) {

        // let's put the url that we want to find about the cat fact in a variable
        String url ="https://catfact.ninja/fact";

        // store the jason in a variable and convert to string

       // String fact = Unirest.get(url).asString().getBody();
        catFact catFact = Unirest.get(url).asObject(catFact.class).getBody();

        String fact = catFact.fact;
        int length = catFact.length;

        System.out.println("A cat fact is: \n" + fact);

        System.out.println("Here is the length of the cat fact string length: " + length);



        // we can print the fact and see what the jason format response from the API looks like

       //System.out.println(fact);

    }
}
// let's create a class and print out more readable string from our jason response

class catFact{

    public String fact;
    public int length;

}
