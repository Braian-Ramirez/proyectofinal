package Logica;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class RestApi {
    UserService userService = new UserService();
    ObjectMapper objectMapper = new ObjectMapper();

    {
        String userInfo = null;
        try {
            userInfo = userService.getPaisInfo();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        JsonNode json = null;
        try {
            json = objectMapper.readTree(userInfo);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        String title = json.get("title").asText();
    }
    }

