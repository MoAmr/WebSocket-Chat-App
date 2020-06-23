package com.readlearncode.dukechat.application;

import org.glassfish.tyrus.server.Server;
import javax.websocket.DeploymentException;
import java.util.Scanner;

/**
 * @author Mohammed Amr
 * @created 24/06/2020 - 00:45
 * @project dukechat
 */
public class ChatServer {

    public static void main(String[] args) {
        Server server =
                new Server("localhost", 8025, "/ws", ChatServerEndpoint.class);
        try {
            server.start();
            System.out.println("Press any key to stop the server..");
            new Scanner(System.in).nextLine();
        } catch (DeploymentException e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }

}
