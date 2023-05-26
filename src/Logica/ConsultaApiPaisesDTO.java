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
        private  String mapa;
        private  String continente;
        private  String subregion;
        private  double area;
        private  double poblacion;
        private  String flag;
        private  String shield;
        private  String name2;
        private  String capital2;
        private  double gini2;
        private  String mapa2;
        private  String continente2;
        private  String subregion2;
        private  double area2;
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
            if( getName().equals("Peru") || getName().equals("Dominican Republic") || getName().equals("Honduras") || getName().equals("Zimbabwe") || getName().equals("Indonesia") || getName().equals("Thailand") || getName().equals("Ukraine") || getName().equals("Armenia") || getName().equals("Turkey") || getName().equals("Bolivia") || getName().equals("Argentina") || getName().equals("Colombia") || getName().equals("Brazil") || getName().equals("Panama") || getName().equals("Paraguay") || getName().equals("Uruguay") || getName().equals("El Salvador") || getName().equals("Ecuador") ){
                this.gini = json.get(0).get("gini").get("2019").asDouble();
            }
            if( getName().equals("Mexico") || getName().equals("Nigeria") || getName().equals("Angola") || getName().equals("Laos") || getName().equals("Kazakhstan") || getName().equals("Philippines") || getName().equals("Pakistan") || getName().equals("Mongolia") ||getName().equals("Finland") || getName().equals("Croatia") ||getName().equals("Hungary") || getName().equals("Netherlands") || getName().equals("Belgium") || getName().equals("Poland") || getName().equals("Denmark") || getName().equals("Norway") || getName().equals("Greece") || getName().equals("Romania") || getName().equals("Sweden") || getName().equals("Switzerland") ||getName().equals("Russia") || getName().equals("Spain") || getName().equals("France") || getName().equals("Portugal") || getName().equals("United States")){
                this.gini = json.get(0).get("gini").get("2018").asDouble();
            }
            if( getName().equals("Italy") || getName().equals("Somalia") || getName().equals("Tanzania") || getName().equals("Iceland") || getName().equals("United Kingdom") || getName().equals("Ireland") || getName().equals("Canada") || getName().equals("Chile")|| getName().equals("Egypt")){
                this.gini = json.get(0).get("gini").get("2017").asDouble();
            }
            if( getName().equals("Germany") ||  getName().equals("North Korea") || getName().equals("Uganda") || getName().equals("South Korea") || getName().equals("Israel") || getName().equals("South Sudan")){
                this.gini = json.get(0).get("gini").get("2016").asDouble();
            }
            if( getName().equals("Malaysia") || getName().equals("Kenya") || getName().equals("Zambia") || getName().equals("Ethiopia")){
                this.gini = json.get(0).get("gini").get("2015").asDouble();
            }
            if( getName().equals("Nicaragua") ||  getName().equals("Guatemala") || getName().equals("Australia") || getName().equals("Yemen") || getName().equals("Cameroon")){
                this.gini = json.get(0).get("gini").get("2014").asDouble();
            }
            if( getName().equals("Japan") || getName().equals("Morocco") ){
                this.gini = json.get(0).get("gini").get("2013").asDouble();
            }
            if( getName().equals("DR Congo") || getName().equals("Haiti") || getName().equals("Iraq") || getName().equals("Madagascar")){
                this.gini = json.get(0).get("gini").get("2012").asDouble();
            }
            if( getName().equals("Chad") || getName().equals("Lebanon") || getName().equals("Senegal") || getName().equals("Algeria")){
                this.gini = json.get(0).get("gini").get("2011").asDouble();
            }
            if( getName().equals("Nepal")){
                this.gini = json.get(0).get("gini").get("2010").asDouble();
            }
            if( getName().equals("Venezuela")){
                this.gini = json.get(0).get("gini").get("2006").asDouble();
            }
            if( getName().equals("Syria")){
                this.gini = json.get(0).get("gini").get("2003").asDouble();
            }

            this.capital = json.get(0).get("capital") .get(0).asText();
            this.poblacion = json.get(0).get("population").asDouble();
            this.area = json.get(0).get("area").asDouble();
            this.continente = json.get(0).get("region").asText();
            this.subregion = json.get(0).get("subregion").asText();
            this.mapa = json.get(0).get("maps").get("googleMaps").asText();
            this.flag = json.get(0).get("flags") .get("png").asText();
            this.shield = json.get(0).get("coatOfArms") .get("png").asText();


            JsonNode json1 = objectMapper.readTree(response1.toString());
            this.name2 = json1.get(0).get("name").get("common").asText();
            if( getName2().equals("Peru") || getName2().equals("Dominican Republic") || getName2().equals("Honduras") || getName2().equals("Zimbabwe") || getName2().equals("Indonesia") || getName2().equals("Thailand") || getName2().equals("Ukraine") ||getName2().equals("Armenia") || getName2().equals("Turkey") || getName2().equals("Bolivia") || getName2().equals("Argentina") || getName2().equals("Colombia") || getName2().equals("Brazil") || getName2().equals("Panama") || getName2().equals("Paraguay") || getName2().equals("Uruguay") || getName2().equals("El Salvador") || getName2().equals("Ecuador") ){
                this.gini2 = json1.get(0).get("gini").get("2019").asDouble();

            }
            if( getName2().equals("Mexico") || getName2().equals("Nigeria") || getName2().equals("Angola") || getName2().equals("Laos") || getName2().equals("Kazakhstan") || getName2().equals("Philippines") || getName2().equals("Pakistan") || getName2().equals("Mongolia") || getName2().equals("Finland") || getName2().equals("Croatia") || getName2().equals("Hungary") || getName2().equals("Netherlands") || getName2().equals("Belgium") || getName2().equals("Poland") || getName2().equals("Denmark") || getName2().equals("Norway") || getName2().equals("Greece") || getName2().equals("Romania") || getName2().equals("Sweden") || getName2().equals("Switzerland") || getName2().equals("Russia") || getName2().equals("Spain") || getName2().equals("France") || getName2().equals("Portugal") || getName2().equals("United States")){
                this.gini2 = json1.get(0).get("gini").get("2018").asDouble();
            }
            if( getName2().equals("Italy") || getName2().equals("Somalia") || getName2().equals("Tanzania") || getName2().equals("Iceland") || getName2().equals("United Kingdom") || getName2().equals("Ireland") || getName2().equals("Canada") || getName2().equals("Chile") || getName2().equals("Egypt")){
                this.gini2 = json1.get(0).get("gini").get("2017").asDouble();
            }
            if( getName2().equals("Germany") ||  getName().equals("North Korea") || getName2().equals("Uganda") || getName2().equals("South Korea") || getName2().equals("Israel") || getName2().equals("South Sudan")){
                this.gini2 = json1.get(0).get("gini").get("2016").asDouble();
            }
            if( getName2().equals("Malaysia") || getName2().equals("Kenya") || getName2().equals("Zambia") || getName2().equals("Ethiopia")){
                this.gini2 = json1.get(0).get("gini").get("2015").asDouble();
            }
            if( getName2().equals("Nicaragua") || getName2().equals("Australia") || getName2().equals("Guatemala") || getName2().equals("Yemen") || getName2().equals("Cameroon")){
                this.gini2 = json1.get(0).get("gini").get("2014").asDouble();
            }
            if( getName2().equals("Japan") || getName2().equals("Morocco") ){
                    this.gini2 = json1.get(0).get("gini").get("2013").asDouble();
            }
            if( getName2().equals("DR Congo") || getName2().equals("Haiti") || getName2().equals("Iraq") || getName2().equals("Madagascar")){
                this.gini2 = json1.get(0).get("gini").get("2012").asDouble();
            }
            if( getName2().equals("Chad") || getName2().equals("Lebanon") || getName2().equals("Senegal") || getName2().equals("Algeria")){
                this.gini2 = json1.get(0).get("gini").get("2011").asDouble();
            }
            if( getName2().equals("Nepal")){
                this.gini2 = json1.get(0).get("gini").get("2010").asDouble();
            }
            if( getName2().equals("Venezuela")){
                this.gini2 = json1.get(0).get("gini").get("2006").asDouble();
            }
            if( getName2().equals("Syria")){
                this.gini2 = json1.get(0).get("gini").get("2003").asDouble();
            }

            this.capital2 = json1.get(0).get("capital") .get(0).asText();
            this.poblacion2 = json1.get(0).get("population").asDouble();
            this.area2 = json1.get(0).get("area").asDouble();
            this.continente2 = json1.get(0).get("region").asText();
            this.subregion2 = json1.get(0).get("subregion").asText();
            this.mapa2 = json1.get(0).get("maps").get("googleMaps").asText();
            this.flag2 = json1.get(0).get("flags") .get("png").asText();
            this.shield2 = json1.get(0).get("coatOfArms") .get("png").asText();

            return " ";
        }
        public  String getName() { return name; }

    public  String getCapital() { return capital; }

    public  double getGini() { return gini; }

    public  double getPoblacion() { return poblacion; }

    public  String getMapa() { return mapa; }

    public double getArea() { return  area;}

    public  String getContinente() { return continente; }

    public  String getSubregion() { return subregion; }

    public  String getFlag() { return flag; }

    public  String getShield() { return shield; }

    public  String getName2() { return name2; }

    public  String getCapital2() { return capital2; }

    public  double getGini2() { return gini2; }

    public  double getPoblacion2() { return poblacion2; }

    public double getArea2() { return area2; }

    public  String getMapa2() { return mapa2; }

    public  String getContinente2() { return continente2; }

    public  String getSubregion2() { return subregion2; }

    public  String getFlag2() { return flag2; }

    public  String getShield2() { return shield2; }
}


