package Logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class UserService {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/todos/";

    public String getUserInfo() throws IOException{
        URL url = new URL(BASE_URL + 6);
        HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if( responseCode != HttpURLConnection.HTTP_OK){
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
