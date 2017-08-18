package xboxapi.Root.Setup;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class POST {



    //www.xboxapi.com paid subscription needed :( 402 without it reeeeee



    public static String Message(String message, String xuid)
    {
        URL url;
        HttpURLConnection connection = null;
        try {

            url = new URL("https://xboxapi.com/v2/messages");
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:37.0) Gecko/20100101 Firefox/37.0");
            connection.setRequestProperty("X-AUTH", "efd8dce102b4fbb0bda1767ccbbc7f46fb40e726");
            connection.setRequestProperty("Content-Type", "application/json");


            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            JSONObject MessageData = new JSONObject();
            JSONArray sendTo = new JSONArray();

            MessageData.put("message",message);
            MessageData.put("to",sendTo);
            sendTo.add(xuid);

            System.out.println(MessageData);

            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream ());
            wr.writeBytes (MessageData.toJSONString());
            wr.flush();
            wr.close();

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }




}