package com.gavin.zeroMq.repReq;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

/**
 * @author gavin
 * @version 1.0
 * @date 2021/8/13 5:39 下午
 * @Description TODO
 */
public class Rep {
    public static void main(String[] args){
        try (ZContext context = new ZContext()) {
            //创建一个 socket  publish类型
            ZMQ.Socket publisher = context.createSocket(SocketType.REP);
            publisher.bind("tcp://*:10000");
            while (true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                String s = publisher.recvStr();
                System.out.println("--RECV:["+s+"]");
                String update="REP: "+System.currentTimeMillis();
                //发送
                publisher.send(update);
                System.out.println("SEND:["+update+"]");
            }
        }
    }
}
