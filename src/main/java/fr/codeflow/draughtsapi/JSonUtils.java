package fr.codeflow.draughtsapi;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonUtils {
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String asPrettyJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var writer = objectMapper.writerWithDefaultPrettyPrinter();
            return writer.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
