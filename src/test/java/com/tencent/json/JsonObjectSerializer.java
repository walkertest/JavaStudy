package com.tencent.json;

import com.google.gson.JsonObject;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public  class JsonObjectSerializer extends JsonSerializer<JsonObject> {

    @Override
    public void serialize(JsonObject jsonObject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeRawValue(jsonObject.toString());
    }
}