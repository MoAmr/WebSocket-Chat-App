package com.readlearncode.dukechat.pingpongchallenge;

import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;
import java.util.Scanner;

/**
 * @author Mohammed Amr
 * @created 24/06/2020 - 02:23
 * @project dukechat
 */
public class PongServer {

    public static void main(String[] args) throws DeploymentException {
        new Server("localhost", 8080, "/ws", PongServerEndpoint.class).start();
        new Scanner(System.in).nextLine();
    }

}