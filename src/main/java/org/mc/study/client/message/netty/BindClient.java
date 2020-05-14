package org.mc.study.client.message.netty;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.TimeUnit;

/**
 * @author machao
 * @date 2019-12-12
 */
public class BindClient {

    private static int MAX_NUM = 5;

    public static void connect(Bootstrap bootstrap, int port, int count) {
        bootstrap.connect("localhost", port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接服务端成功");
            } else if (count == 0) {
                System.out.println("失败次数过多，停止重连！");
            } else {
                int retry = (MAX_NUM - count) + 1;
                int time = 1 << retry;
                System.out.println("连接服务端失败，第" + retry + "次重连");
                bootstrap.config().group().schedule(() -> connect(bootstrap, port, count - 1),
                        time, TimeUnit.SECONDS);
            }

        });
    }

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                    }
                });
        connect(bootstrap, 6001, MAX_NUM);

    }

}
