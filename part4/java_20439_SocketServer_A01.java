import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20439_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here we're using a custom Handler which uses SSL for communication.
                // The Handler class implements Runnable and handles the communication between client and server.
                // The Handler uses SSLSocket from the standard Java libraries to communicate over the network.
                // The Handler uses SSLSocket.accept() and SSLSocket.close() methods to establish and terminate the SSL connection.
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}