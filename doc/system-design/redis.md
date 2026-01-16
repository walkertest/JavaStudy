# redis集群
## 分片算法
- 使用的是hash槽而不是一致性hash，同样可以解决数据均衡问题，hash槽在集群迁移的时候更加方便（直接搬移节点数据），分配策略上可以更灵活，[参考](https://www.cnblogs.com/crazymakercircle/p/18018466)