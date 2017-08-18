package xboxapi.Root.Setup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GET {

    /*
    https://xboxapi.com to get a free api key
    (you can buy subscriptions if you plan on having lots of traffic on the endpoints.
    A Paid subscription also allows you to send messages. (See class "POST.Message"
     */
    private static String API_KEY = "efd8dce102b4fbb0bda1767ccbbc7f46fb40e726";

    public static String Default(String endpoint) {

        String url = "https://xboxapi.com/v2/" + endpoint;
        URL obj = null;
        try {
            obj = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        StringBuffer response = null;
        try {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            try {
                con.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            con.setRequestProperty("X-AUTH", API_KEY);
            BufferedReader in = null;
            try {
                in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                response = new StringBuffer();
                try {
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       return response.toString();
    }

}
