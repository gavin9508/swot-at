package com.gavin.zeroMq.subPub;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Random;

/**
 * @author gavin
 * @version 1.0
 * @date 2021/8/12 5:02 下午
 * @Description TODO
 */
public class Server2 {
    public static void main(String[] args)
    {
        try (ZContext context = new ZContext()) {
            //创建一个 socket  publish类型
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);
            publisher.bind("tcp://*:10001");

            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String update;
                //随机将update赋值为Time: 或Order: 开头的值
                if (random.nextInt(10)<=5) {
                    update = "Time （10001）: "+System.currentTimeMillis();
                } else {
                    update = "Order（10001）: "+System.currentTimeMillis();
                }
                //发送
                publisher.send(update);
                System.out.println("SEND:["+update+"]");
            }
        }
    }
}
