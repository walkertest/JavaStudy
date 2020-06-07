package com.tencent.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.lang.reflect.Type;

public class JSON {

    private static final Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }


    public static String toJson(final Object obj) {
        return gson.toJson(obj);
    }

    public static String toJSONString(final Object obj) {
       return  toJson(obj);
    }

    public static <T> T fromJson(final String str, Class<T> cls) {
        return gson.fromJson(str, cls);
    }

    public static  <T> T parseObject (final String str, Class<T> cls) {
        return fromJson(str, cls);
    }

    public static JsonObject parseObject(final String str) {
        return gson.fromJson(str, JsonObject.class);
    }

    public static JsonArray parseArray(final String str) {
        return gson.fromJson(str, JsonArray.class);
    }

    public static  <T> T parseObject(final String str, Type type) {
        return fromJson(str,type);
    }


    public static JsonElement toJsonTree(final Object obj) {
        return gson.toJsonTree(obj);
    }


    public static <T> T fromJson(final String str, Type type) {
        return gson.fromJson(str, type);
    }
}
