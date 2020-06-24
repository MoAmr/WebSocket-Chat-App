package com.readlearncode.dukechat.pingpongchallenge;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.PongMessage;

/**
 * @author Mohammed Amr
 * @created 24/06/2020 - 02:23
 * @project dukechat
 */
@ClientEndpoint
public class PingClientEndpoint {

    @OnMessage
    public void onMessage(PongMessage pongMessage) {
        System.out.println("Pong received by client from server: " + new String(pongMessage.getApplicationData().array()));
    }

}