package com.cn.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestNIO {
    public static void main(String[] args) throws Exception {
        FileInputStream is = new FileInputStream("d:/person.txt");
        FileChannel channel = is.getChannel();

        FileChannel fileChannel = FileChannel.open(Paths.get("d:/person.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(16);
        fileChannel.read(buffer);

        buffer.flip();
        while (buffer.hasRemaining()){
             byte b = buffer.get();
            System.out.print((char) b);
        }

        fileChannel.close();
    }
}
