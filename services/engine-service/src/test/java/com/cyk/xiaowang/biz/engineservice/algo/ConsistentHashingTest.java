package com.cyk.xiaowang.biz.engineservice.algo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * The class ConsistentHashingTest.
 **/
@Slf4j
public class ConsistentHashingTest {

    private ConsistentHashing consistentHashing;

    @Test
    public void test() {
        Node[] node = new Node[4];
        for (int i = 0; i < node.length; i++) {
            node[i] = new Node(UUID.randomUUID().toString());
            log.info("node {}, {}", i, node[i]);
        }
        consistentHashing = new ConsistentHashing(node, 150);

        String camera1 = "ca4682429c29";
        String camera2 = "ae1bc5dec1f6";
        String camera3 = "8f2a20a8b15a";
        String camera4 = "8f2a20a8ba6d";
        log.info("camera1 get engine {}", consistentHashing.getNode(camera1));
        log.info("camera2 get engine {}", consistentHashing.getNode(camera2));
        log.info("camera3 get engine {}", consistentHashing.getNode(camera3));
        log.info("camera4 get engine {}", consistentHashing.getNode(camera4));

        consistentHashing.remove(node[0]);
        log.info("camera1 get engine {}", consistentHashing.getNode(camera1));
        log.info("camera2 get engine {}", consistentHashing.getNode(camera2));
        log.info("camera3 get engine {}", consistentHashing.getNode(camera3));
        log.info("camera4 get engine {}", consistentHashing.getNode(camera4));
    }
}
