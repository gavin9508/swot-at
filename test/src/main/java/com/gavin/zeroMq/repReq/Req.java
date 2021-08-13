package com.gavin.zeroMq.repReq;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Random;

/**
 * @author gavin
 * @version 1.0
 * @date 2021/8/13 5:36 下午
 * @Description TODO
 */
public class Req {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {
            //创建一个 socket  publish类型 //创建一个 socket  publish类型
            ZMQ.Socket publisher = context.createSocket(SocketType.REQ);
            publisher.connect("tcp://*:10000");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String update = "REQ: " + System.currentTimeMillis();
                publisher.send(update); //发送
                System.out.println("SEND:[" + update + "]");

                String s = publisher.recvStr();
                System.out.println("--RECV:[" + s + "]");
            }
        }
    }
}
