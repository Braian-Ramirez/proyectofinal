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
        private static String name;
        private static String capital;
        private static double gini;
        private static  String flag;
        private static String shield;
        private static String name2;
        private static String capital2;
        private static double gini2;



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
            name = json.get(0).get("name").get("common").asText();
            gini = json.get(0).get("gini").get("2019").asDouble();
            capital = json.get(0).get("capital") .get(0).asText();
            flag = json.get(0).get("flags") .get("png").asText();
            shield = json.get(0).get("coatOfArms") .get("png").asText();
            System.out.println(name);
            System.out.println(flag);
            System.out.println(shield);

            JsonNode json1 = objectMapper.readTree(response1.toString());
            name2 = json1.get(0).get("name").get("common").asText();
            gini2 = json1.get(0).get("gini").get("2019").asDouble();
            capital2 = json1.get(0).get("capital") .get(0).asText();
            System.out.println(name2);
            System.out.println(gini2);
            System.out.println(capital2);
            return " ";
        }
        public static String getName(){
            return name;
        }

    public static String getCapital() {
        return capital;
    }

    public static double getGini() {
        return gini;
    }

    public static String getFlag() {
        return flag;
    }

    public static String getShield() {
        return shield;
    }

    public static String getName2() {
        return name2;
    }

    public static String getCapital2() {
        return capital2;
    }

    public static double getGini2() {
        return gini2;
    }
}


