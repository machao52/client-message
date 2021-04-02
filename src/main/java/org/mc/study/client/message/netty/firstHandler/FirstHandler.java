package org.mc.study.client.message.netty.firstHandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author machao
 * @date 2019-12-22
 */
public class FirstHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + "客户端写出数据");

        for (int i = 0; i < 1000; i++) {
            //1、获取数据
            ByteBuf byteBuf = getByteBuf(ctx);

            //2、写数据
            ctx.channel().writeAndFlush(byteBuf);
        }

    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "你好，拆包粘包理论与解决方案。".getBytes(Charset.forName("UTF-8"));
        ByteBuf byteBuf = ctx.alloc().buffer();
        byteBuf.writeByte(1);
        byteBuf.writeInt(45);
        byteBuf.writeBytes(bytes);

        return byteBuf;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + "客户端读到数据-->" + byteBuf.toString(Charset.forName("UTF-8")));
    }


}
