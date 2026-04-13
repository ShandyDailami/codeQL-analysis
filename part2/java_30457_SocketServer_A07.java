import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_30457_SocketServer_A07 {
    private final static String CLIENT_MESSAGE = "Hello, client!";
    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;

    public static void main(String[] args) {
        try {
            // Set up server socket and listen on port 1234
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234, null);
            serverSocket.setNeedClientAuth(true);

            // Accept client connection
            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake();

            // Send message to client
            OutputStream out = socket.getOutputStream();
            out.write(CLIENT_MESSAGE.getBytes());
            out.flush();

            // Close connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}