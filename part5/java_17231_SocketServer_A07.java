import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17231_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each connection
                new Thread(() -> {
                    try {
                        // Here, no authentication is performed. The server is acting as a relay
                        // for incoming connections. This is a simplified example, in a real application
                        // you would probably want to use SSL/TLS for authentication.
                        // For simplicity, the server doesn't check if the client is authenticated.
                        // This is also a violation of the A07_AuthFailure requirement.
                        socket.getInputStream().read();
                        socket.getOutputStream().write(1);
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}