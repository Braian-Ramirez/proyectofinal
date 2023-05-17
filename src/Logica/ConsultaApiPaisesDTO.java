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
        private  String idioma;
        private  String mapa;
        private  String continente;
        private  String subregion;
        private  double area;
        private  String zonaHoraria;
        private  double poblacion;
        private  double gini;
        private  String flag;
        private  String shield;
        private  String Name2;
        private  String Capital2;
        private  double Gini2;
        private  String Mapa2;
        private  String Continente2;
        private  String Subregion2;
        private  double Area2;
        private  String ZonaHoraria2;
        private  double Poblacion2;
        private  String Flag2;
        private  String Shield2;
        private  String Idioma2;
    private final String BASE_URL = "https://restcountries.com/v3.1/name/";

        public  String getPaisInfo(String nombrePais,String nombrePais2) throws IOException {
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
            System.out.println(name);
            System.out.println(poblacion);
            System.out.println(area);
            System.out.println(zonaHoraria);
            System.out.println(idioma);
            System.out.println(continente);
            System.out.println(subregion);
            System.out.println(mapa);
            System.out.println(flag);
            System.out.println(shield);

            JsonNode json1 = objectMapper.readTree(response1.toString());
            this.Name2 = json1.get(0).get("name").get("common").asText();
            this.Gini2 = json1.get(0).get("gini").get("2019").asDouble();
            this.Capital2 = json1.get(0).get("capital") .get(0).asText();
            this.Poblacion2 = json1.get(0).get("population").asDouble();
            this.Area2 = json1.get(0).get("area").asDouble();
            this.ZonaHoraria2 = json1.get(0).get("timezones").asText();
            this.Continente2 = json1.get(0).get("region").asText();
            this.Subregion2 = json1.get(0).get("subregion").asText();
            this.Idioma2 = json1.get(0).get("languages").asText();
            this.Mapa2 = json1.get(0).get("maps").get("googleMaps").asText();
            this.Flag2 = json1.get(0).get("flags") .get("png").asText();
            this.Shield2 = json1.get(0).get("coatOfArms") .get("png").asText();
            System.out.println(Name2);
            System.out.println(Gini2);
            System.out.println(Capital2);
            System.out.println(Poblacion2);
            System.out.println(Flag2);
            System.out.println(Shield2);
            System.out.println(Area2);
            System.out.println(ZonaHoraria2);
            System.out.println(Idioma2);
            System.out.println(Continente2);
            System.out.println(Subregion2);
            System.out.println(Mapa2);


            return " ";
        }
        public String getName(){
            return name;
        }

        public  String getCapital() {
        return capital;
    }

        public double getGini() {
        return gini;
    }

       public  String getFlag() {
        return flag;
    }

      public String getShield() {
        return shield;
    }

      public double getPoblacion(){return poblacion;}

      public String getIdioma() {
        return idioma;
    }
      public String getMapa(){
            return mapa;
    }

      public  String getContinente() {
        return continente;
    }

      public  String getSubregion() {
        return subregion;
    }

    public String getName2() {
        return Name2;
    }

    public  String getCapital2() {
        return Capital2;
    }

    public double getGini2() {
        return Gini2;
    }

    public double getPoblacion2(){return Poblacion2;}

    public String getIdioma2() {
        return Idioma2;
    }
    public String getMapa2(){
        return Mapa2;
    }

    public  String getContinente2() {
        return Continente2;
    }

    public  String getSubregion2() {
        return Subregion2;
    }
    public  String getFlag2() {
        return Flag2;
    }

    public String getShield2() {
        return Shield2;
    }
}


