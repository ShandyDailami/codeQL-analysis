import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21922_SocketServer_A07 {
    private static final String LOCAL_HOST = "127.0.0.1";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new java.net.InetSocketAddress(LOCAL_HOST, PORT));
            System.out.println("Server started on port " + PORT + ".");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Only accept connections from specific IP
                if (socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                    // Handle the socket here
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}