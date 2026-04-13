import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22942_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                InetAddress clientAddress = socket.getInetAddress();
                System.out.println("Client IP: " + clientAddress.getHostAddress());
                // Only allow access from specific IP
                if (!clientAddress.getHostAddress().equals("192.168.1.1")) {
                    System.out.println("Access denied. Only IP 192.168.1.1 is allowed.");
                    continue;
                }
                // Access granted, perform operations
                System.out.println("Access granted. Performing operations...");
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}