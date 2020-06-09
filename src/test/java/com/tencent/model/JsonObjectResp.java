package com.tencent.model;

import com.google.gson.JsonObject;
import com.tencent.json.JsonObjectSerializer;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@Data
public class JsonObjectResp {
//    @JsonSerialize(using = JsonObjectSerializer.class)
    JsonObject jsonObject;
}
