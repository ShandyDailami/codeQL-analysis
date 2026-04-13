import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_41406_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        // Create SSL server socket
        try {
            sslServerSocket = (SSLServerSocket) serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
       
            // Close server socket
            if (serverSocket != null) {
                serverSocket.close();
            }
        }

        // Accept a new connection
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        InputStream inputStream = sslSocket.getInputStream();
        OutputStream outputStream = sslSocket.getOutputStream();

        // Print the client's IP address and port number
        System.out.println("Client's IP address is " + sslSocket.getRemoteSocketAddress());
        System.out.println("Client's port number is " + sslSocket.getPort());

        // Now, you can send and receive data using the input and output streams
    }
}