import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39181_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT, 10, InetAddress.getByName("127.0.0.1"));
            System.out.println("Server started at port " + PORT);
        } catch (Exception e) {
            System.out.println("Error at server side: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected.");
                handleRequest(socket);
            } catch (Exception e) {
                System.out.println("Error at client side: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void handleRequest(Socket socket) {
        // Here you can add code for your authentication system
        // For now, let's just print a message
        try {
            socket.getInputStream();
            System.out.println("Authentication successful!");
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}