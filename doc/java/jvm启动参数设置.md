# 模版
```declarative
jvmparams= -Djdk.attach.allowAttachSelf=true  --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util.concurrent=ALL-UNNAMED -Dfile.encoding=UTF-8  -Dlog4j2.formatMsgNoLookups=true -XX:MaxRAMPercentage=60.0 -XX:InitialRAMPercentage=60.0  -Xss256k  -XX:+UseG1GC -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDateStamps -XX:+PrintGCDetails     -verbosegc  -Xloggc:${logpath}/gc.log  -XX:+UseGCLogFileRotation -XX:GCLogFileSize=10k -XX:ErrorFile=${logpath}/${app}/${server}/jvm_error.log  -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${logpath}/${app}/${server}/heapdump.hprof -XX:+IgnoreUnrecognizedVMOptions -Xlog:gc*\=info:file\=${logpath}/gc_newversion.log:time,pid:filecount\=7,filesize\=10m
```

# 内存设置
* -XX:MaxRAMPercentage=60.0 -XX:InitialRAMPercentage=60.0，使用按照容器内存的比例去分配，而不是写死，更加通用
* 要求更高的jdk8版本，这里统一版本为openjdk_1.8.0_412


# 垃圾回收器

# 垃圾回收日志
* 部分场景需要分析垃圾回收的日志，以排查垃圾回收相关的问题
* 日志需要做滚动日志，方便脚本去做日志清理，部分服务的日志会很大.

```declarative
Java 8 GC日志滚动配置：
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:/var/log/myapp/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=10M

对于Java 9及以上版本：
-Xlog:gc*:file=/var/log/myapp/gc.log:time,uptimemillis:filecount=10,filesize=10M
```