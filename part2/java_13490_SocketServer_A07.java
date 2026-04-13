import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13490_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 1234; // The port for the server to listen on.

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here, we're just checking if the connection was established by
                // checking if the socket is not null. In a real-world scenario,
                // you'd want to check for authentication.
                if (socket != null) {
                    // Here, we assume that the client is authenticated.
                    // In a real-world scenario, you'd want to check the data received
                    // from the client for authentication.
                    if (authenticateClient(socket)) {
                        new Thread(new SocketClientHandler(socket)).start();
                    } else {
                        System.out.println("Authentication failed for " + socket.getRemoteSocketAddress());
                        socket.close();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Implement your own authentication logic here.
        // For now, we're just returning true.
        return true;
    }
}