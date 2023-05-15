package Logica;
import Presentacion.consultaG;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaApiPaisesDTO {

        private static final String BASE_URL = "https://restcountries.com/v3.1/name/";

        public static String getPaisInfo(String nombrePais,String nombrePais2) throws IOException {
            URL url = new URL(BASE_URL + nombrePais);
            URL url2 = new URL(BASE_URL + nombrePais2);
            System.out.println(BASE_URL + nombrePais);
            System.out.println(BASE_URL + nombrePais2);

            HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
            HttpURLConnection connection1 = (HttpURLConnection) url2.openConnection();
            connection.setRequestMethod("GET");
            connection1.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            int responsecode1 = connection1.getResponseCode();
            if( responseCode != HttpURLConnection.HTTP_OK && responsecode1 != HttpURLConnection.HTTP_OK ){
                throw new RuntimeException("Failed : HTTP error code : " + responseCode + " " + responsecode1);
            }
            BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
            BufferedReader in1 = new BufferedReader( new InputStreamReader(connection1.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            StringBuffer response1 = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            while((inputLine = in1.readLine()) != null) {
                response1.append(inputLine);
            }
            in.close();

           // System.out.println(response.toString());
            //System.out.println(response1.toString());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode json = objectMapper.readTree(response.toString());
            String name = json.get(0).get("name").get("common").asText();
            double gini = json.get(0).get("gini").get("2019").asDouble();
            String capital = json.get(0).get("capital") .get(0).asText();
            System.out.println(name);
            System.out.println(gini);
            System.out.println(capital);

            JsonNode json1 = objectMapper.readTree(response1.toString());
            String name2 = json1.get(0).get("name").get("common").asText();
            double gini2 = json1.get(0).get("gini").get("2017").asDouble();
            String capital2 = json1.get(0).get("capital") .get(0).asText();
            System.out.println(name2);
            System.out.println(gini2);
            System.out.println(capital2);
            return " ";
        }

    }


