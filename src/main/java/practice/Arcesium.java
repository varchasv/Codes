package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Arcesium {
    /*
    public static void main(String[] args) throws IOException {
        //apiResponseParser();
    }
    public static List<Integer> apiResponseParser(List<String> input, int size) throws IOException {

        String response = MyGETRequest();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Response[] response1 = gson.fromJson(response, Response[].class);
        List<Integer> result = check(response1,input);
        return null;
    }

    private static List<Integer> check(Response[] response1, List<String> input) {
        String param = input.get(0);
        String value = input.get(2);
        String command = input.get(1);

        if(param.contains(".")){
            String[] r = param.split(".");
            if(r.length>2){
                List<Integer> rr = checkNestedValue(r[1],response1);
                return rr;
            }else {
                List<Integer> r2 =  checkNestedGeo("geo",response1);
                return r2;
            }
        }else{
            if(value.contains(",")){
                String[] val = value.split(",");
            }else{

            }

        }

    }

    private static List<Integer> checkNestedGeo(String geo, Response[] response1) {

    }

    private static List<Integer> checkNestedValue(String s, Response[] response1) {
    }

    public static String MyGETRequest() throws IOException {
        URL urlForGetRequest = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            System.out.println("JSON String Result " + response.toString());

            return response.toString();

        } else {
            System.out.println("GET NOT WORKED");
        }

        return null;
    }

     */
}

class Response {
    String id;
    String name;
    String username;
    String email;
    String website;
    Address address;
    Company company;
}
class Geo {
    String lat;
    String lng;
}
class Company {
    String name;
    String basename;
}
class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;

}
