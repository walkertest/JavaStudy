package com.tencent.alo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash的封装工具类
 * 1. 将业务的节点数组转换成ConsistentHashNode对象的数组，ConsistentHashNode支持设置虚拟节点数（不同权重），并根据identityString建立一个映射关系，方便找到业务节点.
 * 2. 将ConsistentHashNode对象的数组转换成hash环，参考：buildConsistentHashCircle
 * 3. 根据请求的hash值去选择hash环上的一个ConsistentHashNode， 参考：selectHashCircleNode
 * 4. 根据映射关系映射到具体的业务对象.
 *
 * 这里选择对象映射的方式，而不是继承的方式来实现，是为了减少对业务对象的入侵.
 */
public class ConsistentHash {

    public static TreeMap<Long, ConsistentHashNode> buildConsistentHashCircle(Collection<ConsistentHashNode> nodes) {

        TreeMap<Long, ConsistentHashNode> result = new TreeMap<Long, ConsistentHashNode>();

        for(ConsistentHashNode node: nodes) {
            int replicaNumber = node.getReplicaNumber();
            replicaNumber = replicaNumber / 4 <= 0 ? 1 : replicaNumber / 4;
            for (int i = 0; i < replicaNumber; i++) {
                byte[] digest = md5(node.getIdentityString() + i);
                for (int h = 0; h < 4; h++) {
                    ConsistentHashNode tempNode = (ConsistentHashNode) node.clone();
                    long m = hash(digest, h);
                    tempNode.setHashValue(m);
                    result.put(m, tempNode);
                }
            }
        }
        return result;
    }

    public static ConsistentHashNode selectHashCircleNode(long inputHashKey, TreeMap<Long, ConsistentHashNode> circle) {
        //hash空间是0 ~ 2^32-1
        long dstHashNodeKey = inputHashKey & 0xFFFFFFFFL;
        if(circle != null && circle.isEmpty() == false) {
            //hash环上 顺时针寻找最近的一个节点
            if(circle.containsKey(inputHashKey) == false) {
                SortedMap<Long, ConsistentHashNode> tailMap = circle.tailMap(dstHashNodeKey);
                if (tailMap.isEmpty()) {   //负数或者不在这个区间的数就会命中这个.
                    dstHashNodeKey = circle.firstKey();
                } else {
                    dstHashNodeKey = tailMap.firstKey();
                }
            }

            ConsistentHashNode consistentHashNode = circle.get(dstHashNodeKey);
            return consistentHashNode;
        }

        return null;
    }

    private static byte[] md5(String value) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        md5.reset();
        byte[] bytes = null;
        try {
            bytes = value.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        md5.update(bytes);
        return md5.digest();
    }

    private static long hash(byte[] digest, int number) {
        return (((long) (digest[3 + number * 4] & 0xFF) << 24) | ((long) (digest[2 + number * 4] & 0xFF) << 16) | ((long) (digest[1 + number * 4] & 0xFF) << 8) | (digest[0 + number * 4] & 0xFF)) & 0xFFFFFFFFL;
    }
}
