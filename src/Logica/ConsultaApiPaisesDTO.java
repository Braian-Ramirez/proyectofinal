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
        private  String name;
        private  String capital;
        private  double gini;
        private  String idioma;
        private  String mapa;
        private  String continente;
        private  String subregion;
        private  double area;
        private  String zonaHoraria;
        private  double poblacion;
        private  String flag;
        private  String shield;
        private  String name2;
        private  String capital2;
        private  double gini2;
        private  String idioma2;
        private  String mapa2;
        private  String continente2;
        private  String subregion2;
        private  double area2;
        private  String zonaHoraria2;
        private  double poblacion2;
        private  String flag2;
        private  String shield2;

    private  final String BASE_URL = "https://restcountries.com/v3.1/name/";

        public String getPaisInfo(String nombrePais,String nombrePais2) throws IOException {
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

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode json = objectMapper.readTree(response.toString());
            this.name = json.get(0).get("name").get("common").asText();
            this.gini = json.get(0).get("gini").get("2019").asDouble();
            this.capital = json.get(0).get("capital") .get(0).asText();
            this.poblacion = json.get(0).get("population").asDouble();
            this.area = json.get(0).get("area").asDouble();
            this.zonaHoraria = json.get(0).get("timezones").asText();
            this.continente = json.get(0).get("region").asText();
            this.subregion = json.get(0).get("subregion").asText();
            this.idioma = json.get(0).get("languages").asText();
            this.mapa = json.get(0).get("maps").get("googleMaps").asText();
            this.flag = json.get(0).get("flags") .get("png").asText();
            this.shield = json.get(0).get("coatOfArms") .get("png").asText();
            System.out.println(poblacion);
            System.out.println(continente);
            System.out.println(area);


            JsonNode json1 = objectMapper.readTree(response1.toString());
            this.name2 = json1.get(0).get("name").get("common").asText();
            this.gini2 = json1.get(0).get("gini").get("2018").asDouble();
            this.capital2 = json1.get(0).get("capital") .get(0).asText();
            this.poblacion2 = json1.get(0).get("population").asDouble();
            this.area2 = json1.get(0).get("area").asDouble();
            this.zonaHoraria2 = json1.get(0).get("timezones").asText();
            this.continente2 = json1.get(0).get("region").asText();
            this.subregion2 = json1.get(0).get("subregion").asText();
            this.idioma2 = json1.get(0).get("languages").asText();
            this.mapa2 = json1.get(0).get("maps").get("googleMaps").asText();
            this.flag2 = json1.get(0).get("flags") .get("png").asText();
            this.shield2 = json1.get(0).get("coatOfArms") .get("png").asText();
            System.out.println(flag2);
            return " ";
        }
        public  String getName(){
            return name;
        }

    public  String getCapital() {
        return capital;
    }

    public  double getGini() {
        return gini;
    }

    public  double getPoblacion(){return poblacion;}

    public  String getIdioma() {
        return idioma;
    }

    public  String getMapa(){
            return mapa;
    }

    public double getArea(){ return  area;}

    public  String getContinente() {
        return continente;
    }

    public  String getSubregion() {
        return subregion;
    }

    public  String getFlag() {
        return flag;
    }

    public  String getShield() {
        return shield;
    }

    public  String getName2() {
        return name2;
    }

    public  String getCapital2() {
        return capital2;
    }

    public  double getGini2() {
        return gini2;
    }

    public  double getPoblacion2(){return poblacion2;}

    public double getArea2(){ return area2;}

    public  String getIdioma2() {
        return idioma2;
    }

    public  String getMapa2(){
        return mapa2;
    }

    public  String getContinente2() {
        return continente2;
    }

    public  String getSubregion2() {
        return subregion2;
    }

    public  String getFlag2() {
        return flag2;
    }

    public  String getShield2() {
        return shield2;
    }
}


