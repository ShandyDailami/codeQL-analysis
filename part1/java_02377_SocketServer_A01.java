import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02377_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        int port = 8080; // default port
        ServerSocket serverSocket = null;
        while (true) {
            try {
                serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to client at " + clientSocket.getRemoteSocketAddress());
                // Send message back to client
                String message = "Hello client, you are connected to the server!";
                clientSocket.getOutputStream().write(message.getBytes());
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                if (serverSocket != null) {
                    serverSocket.close();
                }
                System.out.println("Failed to establish a connection on port " + port);
                port++;
            }
        }
    }
}