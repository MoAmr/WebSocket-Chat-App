package com.readlearncode.dukechat.pingpongchallenge;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.Session;
import java.net.URI;
import java.nio.ByteBuffer;

/**
 * @author Mohammed Amr
 * @created 24/06/2020 - 02:23
 * @project dukechat
 */
public class PingClient {

    public static void main(String[] args) throws Exception {

        Session session = ClientManager.createClient().connectToServer(
                PingClientEndpoint.class,
                new URI("ws://localhost:8080/ws/heartbeat"));

        do {

            Thread.sleep(10_000);
            System.out.println("Client sending Pong");
            session.getBasicRemote().sendPong(ByteBuffer.wrap("PONG".getBytes()));

            Thread.sleep(10_000);
            System.out.println("Client sending Ping");
            session.getBasicRemote().sendPing(ByteBuffer.wrap("PING".getBytes()));

        } while (true);

    }

}
