import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_22768_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        Socket socket = null;

        // Create a SSL Server socket
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
            System.out.println("Waiting for client on port 4444");

            // Accept a client connection
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new SSL socket for communication
            SSLSocket sslSocket = (SSLSocket) socket.createChannel();
            sslSocket.setNeedClientAuth(true);

            // Perform SSL handshake
            sslSocket.handshake();
            System.out.println("Client authenticated");

            // Do something with sslSocket here

            // Close the socket
            sslSocket.close();
        } finally {
            if (serverSocket != null)
                serverSocket.close();
            if (socket != null)
                socket.close();
        }
    }
}