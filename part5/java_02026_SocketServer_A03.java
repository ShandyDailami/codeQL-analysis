import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_02026_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Set up SSLServerSocket for server and SSLSocket for client
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Setup server socket
            serverSocket = (SSLServerSocket) new SSLServerSocket(5000);
            System.out.println("Server started");

            // Wait for client connection
            clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            // Handle client connection
            handleClient(clientSocket);
        } finally {
            // Close client and server sockets
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
           
            }
        }
    }

    private static void handleClient(SSLSocket clientSocket) throws IOException {
        // Receive and echo back data
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = clientSocket.getInputStream().read(buffer)) != -1) {
            clientSocket.getOutputStream().write(buffer, 0, bytesRead);
        }
    }
}