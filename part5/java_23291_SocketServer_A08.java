import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23291_SocketServer_A08 {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT, 0, InetAddress.getByName(SERVER_IP));

            System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection established with " + socket.getRemoteSocketAddress());

                // Here you can handle the socket connection
                // For example, you can create a new thread to handle the communication
                new Thread(() -> {
                    // Handle the communication here
                }).start();
              }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}