package ru.mshassium.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.jetbrains.annotations.NotNull;
import ru.mshassium.EchoServiceGrpc;
import ru.mshassium.GrpcEcho;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class EchoClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var client = createEchoClient("localhost", 50051);

        String nextMessage;
        Scanner console = new Scanner(System.in);
        while ((nextMessage = console.nextLine()) != null){
            var request = createRequest(nextMessage);
            var echoResponse = client.getEcho(request);

            System.out.println(echoResponse);
        }

    }

    @NotNull
    private static GrpcEcho.EchoRequest createRequest(String nextMessage) {
        return GrpcEcho.EchoRequest.newBuilder().setMessage(nextMessage).build();
    }

    private static EchoServiceGrpc.EchoServiceBlockingStub createEchoClient(String localhost, int i) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(localhost, i).usePlaintext().build();
        return EchoServiceGrpc.newBlockingStub(channel);

    }

}
