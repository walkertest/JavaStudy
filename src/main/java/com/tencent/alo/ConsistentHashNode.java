package com.tencent.alo;

public class ConsistentHashNode {

    int defaultConHashVirtualNodes = 100;

    int replicaNumber = defaultConHashVirtualNodes;

    String identityString;

    long hashValue;   //根据identityString计算的实际hash值

    public int getReplicaNumber() {
        return replicaNumber;
    }

    public void setReplicaNumber(int replicaNumber) {
        this.replicaNumber = replicaNumber;
    }

    public String getIdentityString() {
        return identityString;
    }

    public void setIdentityString(String identityString) {
        this.identityString = identityString;
    }

    public long getHashValue() {
        return hashValue;
    }

    public void setHashValue(long hashValue) {
        this.hashValue = hashValue;
    }

    @Override
    public String toString() {
        return "ConsistentHashNode{" +
                "defaultConHashVirtualNodes=" + defaultConHashVirtualNodes +
                ", replicaNumber=" + replicaNumber +
                ", identityString='" + identityString + '\'' +
                ", hashValue=" + hashValue +
                '}';
    }

    @Override
    protected Object clone() {
        ConsistentHashNode consistentHashNode = new ConsistentHashNode();
        consistentHashNode.setHashValue(this.hashValue);
        consistentHashNode.defaultConHashVirtualNodes = this.defaultConHashVirtualNodes;
        consistentHashNode.setReplicaNumber(this.replicaNumber);
        consistentHashNode.setIdentityString(this.identityString);
        return consistentHashNode;
    }
}
