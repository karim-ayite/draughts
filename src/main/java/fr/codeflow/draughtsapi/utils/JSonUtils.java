package fr.codeflow.draughtsapi.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.codeflow.draughtsapi.exception.DraughtApiException;

public class JSonUtils {

    private JSonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new DraughtApiException(e);
        }
    }

    public static String asPrettyJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var writer = objectMapper.writerWithDefaultPrettyPrinter();
            return writer.writeValueAsString(obj);
        } catch (Exception e) {
            throw new DraughtApiException(e);
        }
    }



}
