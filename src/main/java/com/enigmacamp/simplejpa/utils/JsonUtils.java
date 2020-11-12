package com.enigmacamp.simplejpa.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils {

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    public String create(Object response) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            log.error(e.getLocalizedMessage());
            return "";
        }
    }
}
