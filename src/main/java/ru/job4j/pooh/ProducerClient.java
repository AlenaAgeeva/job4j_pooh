package ru.job4j.pooh;

import java.io.PrintWriter;
import java.net.Socket;

public class ProducerClient {
    public static void main(String[] args) throws Exception {
        var socket = new Socket("127.0.0.1", 9000);
        try (var out = new PrintWriter(socket.getOutputStream())) {
            int count = 0;
            while (true) {
                out.println("queue;weather;text " + count++);
                out.flush();
            }
        }
    }
}
