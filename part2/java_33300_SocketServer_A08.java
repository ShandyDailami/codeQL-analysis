import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33300_SocketServer_A08 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = server.accept();
                System.out.println("Client connected");
                // Here, we'll add the code to handle the socket connection and integrity failure
                // For simplicity, we'll just print out the address and port of the connected client
                System.out.println("Client address: " + socket.getInetAddress().getHostAddress());
                System.out.println("Client port: " + socket.getPort());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}