package org.mc.study.client.message.netty.protocol;

import lombok.Data;

import static org.mc.study.client.message.netty.protocol.Command.LOGIN_REQUEST;


/**
 * @author machao
 * @date 2021/03/31
 */

@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public byte getCommand() {
        return LOGIN_REQUEST;
    }
}
