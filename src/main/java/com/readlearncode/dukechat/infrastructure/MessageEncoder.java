package com.readlearncode.dukechat.infrastructure;

import com.readlearncode.dukechat.domain.Message;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author Mohammed Amr
 * @created 24/06/2020 - 00:45
 * @project dukechat
 */
public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public String encode(final Message message) throws EncodeException {
        return Json.createObjectBuilder()
                .add("message", message.getContent())
                .add("sender", message.getSender())
                .add("received", "")
                .build().toString();
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
