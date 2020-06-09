package com.tencent.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tencent.model.*;
import com.tencent.util.JsonObjectUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * fastjson的常见用法
 * fastjson平滑迁移到gson,参考：https://juejin.im/post/5e6b9278e51d4526c3591666
 * gson封装static方法有无线程安全问题.
 * fastjson和gson的对比：https://yq.aliyun.com/articles/694560
 */
public class JsonTest {

    @Test
    public void javaObjectToJsonString() {
        Student s1 = new Student(1, "小明", "男", 12);
        String studentJson = JSON.toJSONString(s1);
        System.out.println(studentJson);


        GsonBuilder builder = new GsonBuilder();
//        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();
        String studentJson2 = gson.toJson(s1);
        System.out.println(studentJson2);

        //代理类，兼容fastjson用法.
        String studentJson3 = com.tencent.util.JSON.toJSONString(s1);
        System.out.println(studentJson3);
    }

    @Test
    public void jsonStringToJavaBean() {
        String json = "{\"age\":12,\"gender\":\"男\",\"id\":1,\"name\":\"小明\",\"resultCode\":\"10300\"}";
        Student student = JSON.parseObject(json, Student.class);

        Gson gson = new Gson();
        Student student1 = gson.fromJson(json, Student.class);

        Student student2 = com.tencent.util.JSON.parseObject(json, Student.class);

        System.out.println(student);
        System.out.println(student1);
        System.out.println(student2);
    }

    @Test
    public void jsonStringToJavaBeanComplex() {
        Student s1 = new Student(1, "小明", "男", 12);
        Student s2 = new Student(2, "小芳", "女", 12);

        List<Student> students = Arrays.asList(s1, s2);
        ClassRoom classRoom = new ClassRoom(1, "六年级一班", students);

        String classRoomJson = JSON.toJSONString(classRoom); // 将嵌套对象转成 JSON
        ClassRoom classRoom1 = JSON.parseObject(classRoomJson, ClassRoom.class); // 将 JSON 转成嵌套的对象
        System.out.println(classRoomJson);
        System.out.println(classRoom1);

        Gson gson = new Gson();
        String classRoomJson2 = gson.toJson(classRoom); // 将嵌套对象转成 JSON
        ClassRoom classRoom2 = gson.fromJson(classRoomJson2, ClassRoom.class); // 将 JSON 转成嵌套对象
        System.out.println(classRoomJson2);
        System.out.println(classRoom2);


        String classRoomJson3 = com.tencent.util.JSON.toJSONString(classRoom);
        ClassRoom classRoom3 = com.tencent.util.JSON.parseObject(classRoomJson3, ClassRoom.class);
        System.out.println(classRoomJson3);
        System.out.println(classRoom3);
    }


    @Test
    public void jsonStringToJSONObj() {
        String json = "{\"age\":18, \"grade\": \"六年级\", \"name\": \"小明\", \"score\": 99,\"naMe\": \"小明1\",}";
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println(jsonObject);

        Student student = JSON.parseObject(json,Student.class);
        System.out.println(student);

        String name = jsonObject.getString("name");  // 小明
        String nameFastJson = jsonObject.getString("name1");  // 小明
        Integer score  = jsonObject.getInteger("score"); // 99
        System.out.println(name);
        System.out.println("nameFastJson:" + nameFastJson);
        System.out.println(score);

        Gson gson = new Gson();
        JsonObject jsonObject1 = gson.fromJson(json, JsonObject.class);
        String name2 = jsonObject1.get("name").getAsString(); // 小明
        Integer score2 = jsonObject1.get("score").getAsInt(); // 99
        String nameTest = JsonObjectUtil.getString(jsonObject1,"name1");
        System.out.println("nameTest:" + nameTest);
        System.out.println(name2);
        System.out.println(score2);

        //
        JsonObject jsonObject2 = com.tencent.util.JSON.parseObject(json);
        String name3 = jsonObject2.get("name").getAsString(); // 小明
        Integer score3 = jsonObject2.get("score").getAsInt(); // 99
        System.out.println(name3);
        System.out.println(score3);
    }

    @Test
    public void jsonStringToJsonArray() {
        String json = "[{\"age\":18, \"grade\": \"六年级\", \"name\": \"小明\", \"score\": 99},{\"age\":18, \"grade\": \"六年级\", \"name\": \"小芳\", \"score\": 100}]";

        List<JSONObject> testList = JSON.parseObject(json,List.class);
        for(JSONObject jsonObject : testList) {
            System.out.println(jsonObject);
        }

        Gson gson = new Gson();
        List<JsonObject> jsonObjectList = com.tencent.util.JSON.parseArray(json,JsonObject.class);
        for(JsonObject jsonObject : jsonObjectList) {
            System.out.println(jsonObject);
        }



        JSONArray jsonArray = JSON.parseArray(json);

        String name0_1 = jsonArray.getJSONObject(0).getString("name"); // 小明
        String name1_1 = jsonArray.getJSONObject(1).getString("name"); // 小芳
        System.out.println(name0_1);
        System.out.println(name1_1);



        JsonArray jsonArray2 = gson.fromJson(json, JsonArray.class);
        String name0_2 = jsonArray2.get(0).getAsJsonObject().get("name").getAsString(); // 小明
        String name1_2 = jsonArray2.get(1).getAsJsonObject().get("name").getAsString(); // 小芳
        System.out.println(name0_2);
        System.out.println(name1_2);

        //
        JsonArray jsonArray3 = com.tencent.util.JSON.parseArray(json);
        String name0_3 = jsonArray3.get(0).getAsJsonObject().get("name").getAsString(); // 小明
        String name1_3 = jsonArray3.get(1).getAsJsonObject().get("name").getAsString(); // 小芳
        System.out.println(name0_3);
        System.out.println(name1_3);


        List<Student> studentList = com.tencent.util.JSON.parseArray(json,Student.class);
        System.out.println(studentList);
        for(Student student: studentList) {
            System.out.println(student);
        }

    }


    @Test
    public void typeReferance() {
        Student s1 = new Student(1, "小明", "男", 12);
        Student s2 = new Student(2, "小芳", "女", 12);
        List<Student> students = Arrays.asList(s1,s2);

        String json = JSON.toJSONString(students);

        Type type = new TypeReference<List<Student>>(){}.getType(); // 在这里需要获取完整的泛型类型
        List<Student> studentsRet = JSON.parseObject(json, type);
        System.out.println(json);
        System.out.println(studentsRet);

        Gson gson = new Gson();
        Type type2 = new TypeToken<List<Student>>() {}.getType(); // 获取泛型类型

        String json2 = gson.toJson(students);
        List<Student> studentsRet2 = gson.fromJson(json2, type2);
        System.out.println(json2);
        System.out.println(studentsRet2);


        //
        String json3 = com.tencent.util.JSON.toJSONString(students);
        List<Student> studentsRet3 =  com.tencent.util.JSON.parseObject(json3,type2);
        System.out.println(json3);
        System.out.println(studentsRet3);




    }

    @Test
    public void testGetBoolean() {
        JSONObject jsonObject = new JSONObject();
        Boolean value = jsonObject.getBoolean("test");
        boolean value2 = jsonObject.getBooleanValue("test");
        System.out.println(value);
        System.out.println(value2);
    }


    @Test
    public void testGsonToJackson() throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("test","test");
        List<JsonObject> jsonObjectList = new ArrayList<>();
        jsonObjectList.add(jsonObject);
        JsonObjectResp jsonObjectResp = new JsonObjectResp();
        jsonObjectResp.setList(jsonObjectList);



        ObjectMapper mapper = new ObjectMapper();
        String json=mapper.writeValueAsString(jsonObjectResp);
        System.out.println(json);
    }

    @Test
    public void testFastJsonToJackson() throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test","test");
        List<JSONObject> jsonObjectList = new ArrayList<>();
        jsonObjectList.add(jsonObject);

        FastJSONObjectResp fastJSONObjectResp = new FastJSONObjectResp();
        fastJSONObjectResp.setList(jsonObjectList);
        ObjectMapper mapper = new ObjectMapper();
        String json=mapper.writeValueAsString(fastJSONObjectResp);
        System.out.println(json);

    }

    @Test
    public void testMapToJackson() throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("test", "test");
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);
        JsonMapResp jsonMapResp = new JsonMapResp();
        jsonMapResp.setList(list);
        ObjectMapper mapper = new ObjectMapper();
        String json=mapper.writeValueAsString(jsonMapResp);
        System.out.println(json);
    }


}
