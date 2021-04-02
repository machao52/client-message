package org.mc.study.client.message.netty.firstHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author machao
 * @date 2019-12-22
 */
public class NettyClient {

    public final static String HOST = "127.0.0.1";
    public final static int PORT = 6000;

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();

        bootstrap.group(nioEventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new FixedLengthFrameDecoder(18));
                        ch.pipeline().addLast(new FirstHandler());
                    }
                });

        bootstrap.connect(HOST, PORT).channel();
    }

}
