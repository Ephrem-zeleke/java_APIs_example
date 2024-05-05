import kong.unirest.Unirest;

public class exchangeRateConverter {
    public static void main(String[] args) {

        //let's assign a variable for our url

        String url = "https://1150-exchange-rates.azurewebsites.net/latest?base=USD&symbols=EUR";

        RateResponse rateResponse = Unirest.get(url).asObject(RateResponse.class).getBody();

        String dateRequested = rateResponse.date;

        double rates = rateResponse.rates.EUR;

        System.out.println("On " + dateRequested + " the exchange rate from USD to EUR is " + rates);






    }
}

class RateResponse {

    public String base;
    public String date;

    public Rates rates;
}

class Rates {
    public double EUR;
}