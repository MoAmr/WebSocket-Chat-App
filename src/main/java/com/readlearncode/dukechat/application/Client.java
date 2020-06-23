package com.readlearncode.dukechat.application;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.Session;
import java.net.URI;
import java.util.Scanner;

import static com.readlearncode.dukechat.infrastructure.JsonUtil.formatMessage;

/**
 * @author Mohammed Amr
 * @created 24/06/2020 - 00:45
 * @project dukechat
 */
public class Client {

    public static void main(String[] args) throws Exception {

        ClientManager client = ClientManager.createClient();

        // Start welcome code
        String message;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tiny Chat!");
        System.out.println("What's your name?");
        String user = scanner.nextLine();
        // End welcome code

        Session session = client.connectToServer(
                ChatClientEndpoint.class,
                new URI("ws://localhost:8025/ws/chat"));

        System.out.println("You are logged in as: " + user);

        do {
            // repeatedly read a message and send it to the server (until quit)
            message = scanner.nextLine();
            session.getBasicRemote().sendText(formatMessage(message, user));
        } while (!message.equalsIgnoreCase("quit"));
    }

}
