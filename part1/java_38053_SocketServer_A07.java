import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38053_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Authentication
            AuthenticationHandler authenticationHandler = new AuthenticationHandler(socket);
            if (!authenticationHandler.authenticate(PASSWORD)) {
                System.out.println("Authentication failed, closing connection");
                socket.close();
                continue;
            }

            // If authentication successful, handle the request
            RequestHandler requestHandler = new RequestHandler(socket);
            requestHandler.handle();
       
        }
    }
}