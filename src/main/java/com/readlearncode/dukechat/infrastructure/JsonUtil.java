package com.readlearncode.dukechat.infrastructure;

import javax.json.Json;

/**
 * @author Mohammed Amr
 * @created 24/06/2020 - 00:45
 * @project dukechat
 */
public class JsonUtil {

    public static String formatMessage(String message, String user) {
        return Json.createObjectBuilder()
                .add("message", message)
                .add("sender", user)
                .add("received", "")
                .build().toString();
    }
}
