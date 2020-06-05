package com.tencent.json;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.tencent.model.Student;
import org.junit.Test;

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
}
