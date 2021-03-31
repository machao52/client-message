package org.mc.study.client.message.netty.protocol;


import lombok.Data;

import static org.mc.study.client.message.netty.protocol.Command.LOGIN_RESPONSE;

/**
 * @author machao
 * @date 2021/03/31
 */

@Data
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String reason;

    @Override
    public byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
