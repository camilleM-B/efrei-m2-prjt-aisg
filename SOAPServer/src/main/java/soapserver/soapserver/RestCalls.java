package soapserver.soapserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestCalls {
    private static String USER_AGENT = "Firefox";

    public static String sendGET(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        return "";

    }

    public static Boolean sendPUT(String PUT_URL) throws IOException {
        URL obj = new URL(PUT_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("User-Agent", USER_AGENT);

        // For PUT only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.flush();
        os.close();
        // For PUT only - END

        int responseCode = con.getResponseCode();
        System.out.println("PUT Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response);
            return Boolean.parseBoolean(response.toString());
        } else {
            System.out.println("PUT request not worked");
        }
        return false;
    }
}
