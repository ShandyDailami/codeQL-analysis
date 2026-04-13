import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12601_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Handle the client here
                // For simplicity, we'll print out a message
                // to the client that the connection was successful
                socket.getOutputStream().write(("Connection successful\n").getBytes());
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}