package Logica;
import Presentacion.consultaG;

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

public class ConsultaChatGptDTO {
    consultaG consultaG = new consultaG();
    public String getConsultaGpt(String consulta) {
        String apiUrl = "https://api.openai.com/v1/completions";
        String openaiApikey = "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";
        String text = null;
        {
            URL url = null;
            try {
                url = new URL(apiUrl);
            } catch (MalformedURLException ex) {
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
            //String jsonInputString = "{\"model\":\"text-davinci-003\",\"prompt\":\""+consulta+"\",\"max_tokens\":70,\"temperature\":0.8}";
            String jsonInputString = "{\"model\":\"text-davinci-003\",\"prompt\":\"digame que dia es hoy en Colombia\",\"max_tokens\":70,\"temperature\":0.8}";

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(jsonInputString.getBytes());
                outputStream.flush();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            StringBuilder response = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputline;
                while ((inputline = bufferedReader.readLine()) != null) {
                    response.append(inputline);
                }
                System.out.println(response);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = null;

            try {
                jsonResponse = objectMapper.readTree(response.toString());
                System.out.println(jsonResponse.get("choices"));
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
            JsonNode choices = jsonResponse.get("choices");

            for (JsonNode choice : choices) {
                text = choice.get("text").asText();
                System.out.println(text);

            }

        }

        return text;
    }
}

