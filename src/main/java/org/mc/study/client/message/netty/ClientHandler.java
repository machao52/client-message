package org.mc.study.client.message.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.mc.study.client.message.netty.protocol.LoginRequestPacket;
import org.mc.study.client.message.netty.protocol.LoginResponsePacket;
import org.mc.study.client.message.netty.protocol.Packet;
import org.mc.study.client.message.netty.protocol.PacketCode;

/**
 * @author machao
 * @date 2021/03/31
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端开始登陆。。。");

        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setUserId("A999888");
        loginRequestPacket.setUsername("好好先生");
        loginRequestPacket.setPassword("123456");

        ByteBuf byteBuf = PacketCode.INSTANCE.encode(ctx.alloc(), loginRequestPacket);

        ctx.channel().writeAndFlush(byteBuf);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCode.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
            if (loginResponsePacket.isSuccess()) {
                System.out.println("客户端登录成功！");
            }
        }

    }

}
