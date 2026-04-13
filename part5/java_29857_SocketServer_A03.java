import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29857_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");

                new Thread(() -> {
                    // Handle client request
                    try {
                        // Read request from client
                        // ...

                        // Send response back to client
                        // ...

                        // Close connection
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