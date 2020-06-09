package com.tencent.model;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.Data;

import java.util.List;

@Data
public class FastJSONObjectResp {
    List<JSONObject> list;
}
