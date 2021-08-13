package com.gavin.zeroMq.subPub;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

/**
 * @author gavin
 * @version 1.0
 * @date 2021/8/12 4:56 下午
 * @Description TODO
 */
public class Client2 {
    public static void main(String args[]) {
        try (ZContext context = new ZContext()) {
            //创建一个 socket  publish类型
            ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
            subscriber.connect("tcp://localhost:10000");
            subscriber.connect("tcp://localhost:10001");
            //只订阅Order: 开头的信息
            subscriber.subscribe("Order".getBytes());
            for (int i = 0; i < 1000; i++) {
                Thread.sleep(1000);
                //recvStr直接返回String，内部调用了recv，将byte数组转化为String
                System.out.println(subscriber.recvStr());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
