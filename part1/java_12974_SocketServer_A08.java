import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_12974_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Setup SSL Server
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuthentication(true);

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            // Get the SSL socket connection
            SSLSocket sslClientSocket = (SSLSocket) clientSocket.getSocket();

            // Create InputStream and OutputStream
            InputStream in = sslClientSocket.getInputStream();
            OutputStream out = sslClientSocket.getOutputStream();

            // Send some data
            out.write("Hello, Client!".getBytes());

            // Read the data from the client
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);

            // Print the data
            System.out.println("Server says: " + new String(buffer, 0, bytesRead));

            // Close the connection
            sslClientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}