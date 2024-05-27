package com.cyk.xiaowang.biz.engineservice.algo;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The class ConsistentHashing.
 **/
public class ConsistentHashing {

    private final SortedMap<Integer, Node> hashCircle = new TreeMap<>();
    private final int virtualNums; // 虚拟节点数

    public ConsistentHashing(Node[] nodes, int virtualNums) {
        this.virtualNums = virtualNums;
        // 初始化一致性hash环
        for (Node node : nodes) {
            // 创建虚拟节点
            add(node);
        }
    }

    /**
     * 添加服务器节点
     *
     * @param node the server
     */
    public void add(Node node) {
        for (int i = 0; i < virtualNums + 1; i++) {
            hashCircle.put(hash(node.engineId() + i), node);
        }
    }

    /**
     * 删除服务器节点
     *
     * @param node the server
     */
    public void remove(Node node) {
        for (int i = 0; i < virtualNums + 1; i++) {
            hashCircle.remove(hash(node.engineId() + i));
        }
    }

    /**
     * 获取服务器节点
     *
     * @param key the key
     * @return the server
     */
    public Node getNode(String key) {
        if (key == null || hashCircle.isEmpty())
            return null;
        int hash = hash(key);
        if (!hashCircle.containsKey(hash)) {
            // 未命中对应的节点
            SortedMap<Integer, Node> tailMap = hashCircle.tailMap(hash);
            hash = tailMap.isEmpty() ? hashCircle.firstKey() : tailMap.firstKey();
        }
        return hashCircle.get(hash);
    }

    /**
     * FNV1_32_HASH算法
     *
     * @param key the key
     * @return
     */
    private int hash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
}
