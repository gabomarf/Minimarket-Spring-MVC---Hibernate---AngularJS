package com.mini.jstransformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import java.io.IOException;

public class JsonTransformerImpl implements JsonTransformer{

     @Override
    public  String toJson(Object data) {
        String result = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Hibernate4Module hbm = new Hibernate4Module();
            hbm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
            mapper.registerModule(hbm);
            ObjectWriter w = mapper.writer();            
            result = w.writeValueAsString(data);           
            
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
 
    @Override
    public Object fromJson(String json, Class clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
 
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
