package org.mc.study.client.message.netty.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author machao
 * @date 2019-12-11
 */
public class IoClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket=new Socket("localhost",6000);
        while(true){
            OutputStream outputStream=socket.getOutputStream();

            String str="客户端1：发送数据 "+System.currentTimeMillis();
            outputStream.write(str.getBytes());
            Thread.sleep(2000);
        }

    }

}
