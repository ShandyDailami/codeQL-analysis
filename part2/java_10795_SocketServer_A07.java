import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_10795_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a SSL ServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();

            System.out.println("Connection accepted from " + clientSocket.getRemoteSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}