package com.tencent.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonObjectUtil {
    public static String getString(JsonObject jsonObject, String key) {
        JsonElement jsonElement = jsonObject.get(key);
        if(jsonElement == null) {
            return null;
        } else {
            return jsonElement.getAsString();
        }
    }

    public static Integer getInteger(JsonObject jsonObject, String key) {
        JsonElement jsonElement = jsonObject.get(key);
        if(jsonElement == null) {
            return null;
        } else {
            return jsonElement.getAsInt();
        }
    }

    public static int getIntValue(JsonObject jsonObject, String key) {
        JsonElement jsonElement = jsonObject.get(key);
        if(jsonElement == null) {
            return 0;
        } else {
            return jsonElement.getAsInt();
        }
    }
}
