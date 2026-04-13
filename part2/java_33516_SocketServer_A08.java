import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_33516_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a SSLServerSocket with a custom SSLContext
        SSLServerSocket serverSocket = new SSLServerSocket(
                (ServerSocket)null,
                null,
                null,
                SSLServerSocket.SELECT_CHANNEL_WRITE_BUFFER_SIZE);

        // Set up an SSLSocketFactory for the server
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();
        SSLServerSocket serverSocketSecured = (SSLServerSocket) sslServerSocketFactory.createServerSocket(serverSocket);

        // Bind the serverSocket to a port
        serverSocketSecured.bind(new InetSocketAddress(8080));

        while (true) {
            // Wait for a client to connect
            SSLSocket clientSocket = (SSLSocket) serverSocketSecured.accept();

            // Start a new thread to handle communications
            new ClientThread(clientSocket).start();
        }
    }
}