import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class java_37832_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            System.out.println("Waiting for client authentication...");

            SSLSocket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            clientSocket.startHandshake();

            // Perform authentication here
            HelloRequest helloRequest = (HelloRequest) clientSocket.getNeededObject();
            System.out.println("Client says: " + helloRequest.toString());

            // Create custom authentication handler
            AuthenticationHandler authenticationHandler = new AuthenticationHandler();
            clientSocket.setAuthenticationHandler(authenticationHandler);

            // Continue with business logic here
        } finally {
            serverSocket.close();
        }
    }
}