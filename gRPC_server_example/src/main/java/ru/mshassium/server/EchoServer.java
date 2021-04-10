package ru.mshassium.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ru.mshassium.EchoServiceGrpc;

import java.io.IOException;

public class EchoServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051).addService(new EchoService()).build();
        Server start = server.start();
        start.awaitTermination();
    }

}
