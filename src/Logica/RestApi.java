package Logica;
import  Presentacion.consultaG;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.IOException;

public class RestApi {
    ConsultaApiPaisesDTO consultaApiPaisesDTOonsulta = new ConsultaApiPaisesDTO();
    ObjectMapper objectMapper = new ObjectMapper();

    consultaG consultaG = new consultaG();

    {
        String paisInfo = null;
        try {
            paisInfo = ConsultaApiPaisesDTO.getPaisInfo(consultaG.paisTextField.getText());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        JsonNode json = null;
        try {
            json = objectMapper.readTree(paisInfo);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        String title = json.get("title").asText();
    }
    }

