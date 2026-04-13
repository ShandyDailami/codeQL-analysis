import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_26936_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);
        } catch (SSLException e) {
            System.err.println("Failed to create SSLServerSocket: " + e.getMessage());
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.err.println("Failed to accept the client connection: " + e.getMessage());
            System.exit(1);
        }

        SSLSocket sslSocket = null;
        try {
            sslSocket = (SSLSocket) clientSocket.createChannel(clientSocket.getChannel());
            sslSocket.setNeedClientAuth(true);
            sslSocket.startHandshake();
        } catch (IOException e) {
            System.err.println("Failed to create SSLSocket: " + e.getMessage());
            System.exit(1);
        }

        // Now we can safely use sslSocket for communication
        try (InputStream in = sslSocket.getInputStream(); OutputStream out = sslSocket.getOutputStream()) {
            // Here is where you would normally read and write data
            // For this example, we just print out the data
            int bytesRead;
            byte[] bytes = new byte[1024];
            while ((bytesRead = in.read(bytes)) != -1) {
                System.out.write(bytes, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Failed to read/write through sslSocket: " + e.getMessage());
            System.exit(1);
        }

        try {
            sslSocket.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Failed to close sslSocket, clientSocket or serverSocket: " + e.getMessage());
            System.exit(1);
        }
    }
}