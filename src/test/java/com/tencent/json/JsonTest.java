package com.tencent.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tencent.model.ClassRoom;
import com.tencent.model.Student;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * 复现fastjson的安全问题
 * fastjson的常见用法
 * fastjson平滑迁移到gson,参考：https://juejin.im/post/5e6b9278e51d4526c3591666
 * gson封装static方法有无线程安全问题.
 */
public class JsonTest {

    @Test
    public void javaObjectToJsonString() {
        Student s1 = new Student(1, "小明", "男", 12);
        String studentJson = JSON.toJSONString(s1);
        System.out.println(studentJson);

        Gson gson = new Gson();
        String studentJson2 = gson.toJson(s1);
        System.out.println(studentJson2);
    }

    @Test
    public void jsonStringToJavaBean() {
        String json = "{\"age\":12,\"gender\":\"男\",\"id\":1,\"name\":\"小明\"}";
        Student student = JSON.parseObject(json, Student.class);

        Gson gson = new Gson();
        Student student1 = gson.fromJson(json, Student.class);

        System.out.println(student);
        System.out.println(student1);
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
    }


    @Test
    public void jsonStringToJSONObj() {
        String json = "{\"age\":18, \"grade\": \"六年级\", \"name\": \"小明\", \"score\": 99}";
        JSONObject jsonObject = JSON.parseObject(json);

        String name = jsonObject.getString("name");  // 小明
        Integer score  = jsonObject.getInteger("score"); // 99
        System.out.println(name);
        System.out.println(score);

        Gson gson = new Gson();
        JsonObject jsonObject1 = gson.fromJson(json, JsonObject.class);
        String name2 = jsonObject1.get("name").getAsString(); // 小明
        Integer score2 = jsonObject1.get("score").getAsInt(); // 99
        System.out.println(name2);
        System.out.println(score2);
    }

    @Test
    public void jsonStringToJsonString() {
        String json = "[{\"age\":18, \"grade\": \"六年级\", \"name\": \"小明\", \"score\": 99},{\"age\":18, \"grade\": \"六年级\", \"name\": \"小芳\", \"score\": 100}]";

        JSONArray jsonArray = JSON.parseArray(json);

        String name0_1 = jsonArray.getJSONObject(0).getString("name"); // 小明
        String name1_1 = jsonArray.getJSONObject(1).getString("name"); // 小芳
        System.out.println(name0_1);
        System.out.println(name1_1);

        Gson gson = new Gson();

        JsonArray jsonArray2 = gson.fromJson(json, JsonArray.class);
        String name0_2 = jsonArray2.get(0).getAsJsonObject().get("name").getAsString(); // 小明
        String name1_2 = jsonArray2.get(1).getAsJsonObject().get("name").getAsString(); // 小芳
        System.out.println(name0_2);
        System.out.println(name1_2);

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
        List<Student> studentsRet2 = gson.fromJson(json, type2);
        System.out.println(json2);
        System.out.println(studentsRet2);


    }


}
