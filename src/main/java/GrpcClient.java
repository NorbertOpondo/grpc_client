import com.norbert.grpc.User;
import com.norbert.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

  public static void main(String[] args) {

    final ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();


    final userGrpc.userBlockingStub blockingStub = userGrpc.newBlockingStub(managedChannel);

    User.LoginRequest loginRequest = User.LoginRequest.newBuilder()
        .setUsername("Norbert").setPassword("Norbert").build();

    final User.APIResponse apiResponse = blockingStub.login(loginRequest);

    System.out.println("apiResponse = " + apiResponse);
  }
}
