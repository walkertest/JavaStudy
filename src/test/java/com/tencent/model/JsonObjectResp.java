package com.tencent.model;

import com.google.gson.JsonObject;
import lombok.Data;

import java.util.List;

@Data
public class JsonObjectResp {
    List<JsonObject> list;
}
