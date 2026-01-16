[toc]
# 参数设置
- G1:-XX:+UseG1GC
- ZGC:-XX:+UseZGC -XX:+ZGenerational(JDK25中，默认为分代ZGC)

# 原理
- 不分代ZGC的每次收集都是全堆扫描，虽然延迟很低，但吞吐量可能受影响
- 分代ZGC则能频繁、廉价地回收新生代，只有必要时才触发更耗时但对吞吐量影响小的老年代回收。分代ZGC在几乎保持相同超低延迟的同时，显著提升了吞吐量并降低了内存开销

# 对比效果
- 对比方式：压测、线上服务
- jdk25服务
- 对比参数：cpu、耗时（平均耗时、p99耗时）、其他jvm参数

## 线上服务对比
- 日志上报服务和设备画像服务

# 参考
- 主站评测：https://doc.weixin.qq.com/doc/w3_AF0A7QbMAJ0CBE2Tj8DTA0zG0MlWT?scode=AFIANgeJAA07haDrKCAEoA8AbMAJ0