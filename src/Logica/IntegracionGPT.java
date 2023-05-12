package Logica;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class IntegracionGPT {

    String apiUrl = "https://api.openai.com/v1/completions";
    String openaiApikey = "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";
    {
        URL url = null;
        try {
            url = new URL(apiUrl);
        } catch (MalformedURLException ex) {
            // ¨Prueba de cambios
            throw new RuntimeException(ex);
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException ex) {
            throw new RuntimeException(ex);
        }
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + openaiApikey);
        connection.setDoOutput(true);
        String jsonInputString = "{\"model\":\"text-davinci-003\",\"prompt\":\"quien soy yo?\",\"max_tokens\":70,\"temperature\":0.8}";

        try( OutputStream outputStream = connection.getOutputStream()){
           outputStream.write(jsonInputString.getBytes());
           outputStream.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        StringBuilder response = new StringBuilder();
         try( BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(connection.getInputStream()))){
         String inputline;
         while(( inputline = bufferedReader.readLine()) != null){
             response.append(inputline);
         }
        } catch (IOException ex) {
             throw new RuntimeException(ex);
         }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = null;
        try {
            jsonResponse = objectMapper.readTree(response.toString());
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        JsonNode choices = jsonResponse.get("choices");

         for ( JsonNode choice : choices){
             String text = choice.get("text").asText();
             System.out.println(text);
         }
    }

    }




