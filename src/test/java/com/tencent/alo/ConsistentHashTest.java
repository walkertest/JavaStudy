package com.tencent.alo;

import org.junit.Test;
import java.util.*;

public class ConsistentHashTest {

    @Test
    public void test() {
        System.out.println(Math.pow(2,32)-1);
        Collection<ConsistentHashNode> nodes = getConsistentHashNodes();

        TreeMap<Long, ConsistentHashNode> circle = ConsistentHash.buildConsistentHashCircle(nodes);
        System.out.println("circle size:" + circle.size());
//        System.out.println(circle);
//        System.out.println(JSON.toJson(circle));

        List<? extends Number> hashKeys = Arrays.asList(-1,12345,0,123450,1234500,12345000,
                123450000L,1234500000L);

        for (Number number : hashKeys) {
            ConsistentHashNode consistentHashNode = ConsistentHash.selectHashCircleNode(number.longValue(), circle);
            System.out.println(number.longValue() + " " + consistentHashNode);
        }

    }

    @Test
    public void test2() {
        long data = (Long)(0xFFFFFFFFL & 0xFFFFFFFFL);
        System.out.println(data);

        int data1 = (int) data;
        System.out.println(data1);

        System.out.println("test12345test".hashCode());

        String test = null;
        System.out.println(test.hashCode());
    }

    private static Collection<ConsistentHashNode> getConsistentHashNodes() {
        Collection<ConsistentHashNode> nodes = new ArrayList<>();
        ConsistentHashNode node1 = new ConsistentHashNode();
        node1.setIdentityString("127.0.0.1:8001");
        node1.setReplicaNumber(60);

        ConsistentHashNode node2 = new ConsistentHashNode();
        node2.setIdentityString("127.0.0.1:8002");
        node2.setReplicaNumber(80);

        ConsistentHashNode node3 = new ConsistentHashNode();
        node3.setIdentityString("127.0.0.1:8003");
        node3.setReplicaNumber(100);

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        return nodes;
    }

}