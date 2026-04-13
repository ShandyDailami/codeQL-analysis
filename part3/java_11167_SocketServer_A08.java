import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11167_SocketServer_A08 {

    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started on port: " + SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Here you can add code to validate the integrity of the data sent over the socket.
            // For simplicity, we will just verify that the socket is not null.
            if (socket == null) {
                System.out.println("Invalid socket connection. Skipping...");
                continue;
            }

            // Handle the socket connection here.
            // For example, we will simply close the connection here.
            socket.close();
        }
    }
}