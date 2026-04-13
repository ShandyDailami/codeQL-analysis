import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35603_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Simulate a security sensitive operation that throws an IntegrityFailure
            try {
                throw new SecurityFailureException("Security failure detected");
            } catch (SecurityException e) {
                System.out.println("Security exception caught. Server shutting down...");
                socket.close();
                serverSocket.close();
                System.exit(0);
            }
       
            // Handle the client connection here
        }
    }
}