package ru.mshassium.server;

import io.grpc.stub.StreamObserver;
import ru.mshassium.EchoServiceGrpc;
import ru.mshassium.GrpcEcho;

public class EchoService extends EchoServiceGrpc.EchoServiceImplBase {

    @Override
    public void getEcho(GrpcEcho.EchoRequest request, StreamObserver<GrpcEcho.EchoResponse> responseObserver) {
        responseObserver.onNext(GrpcEcho.EchoResponse.newBuilder().setMessage("Echo: " + request.getMessage()).build());
        responseObserver.onCompleted();
    }
}
