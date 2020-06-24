package com.readlearncode.dukechat.application;

import com.readlearncode.dukechat.utils.Messages;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 * @author Mohammed Amr
 * @created 24/06/2020 - 02:11
 * @project dukechat
 */
@Stateless
class DukeBotSchedular {

    @Schedule(minute = "*/20", hour = "*")
    private void interrupt() {
        ChatServerEndpoint.getRooms().forEach((s, room) -> room.sendMessage(Messages.objectify("Hello from Duke Bot")));
    }

}
