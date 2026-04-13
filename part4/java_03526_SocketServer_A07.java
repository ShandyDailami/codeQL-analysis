import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_03526_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        // Load the trusted certificate
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
        sslServerSocket.setNeedClientAuth(true);

        // Accept a client connection
        sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.startHandshake();

        // Send the response
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
        out.println("Hello Client, you are connected to Secure Socket Server");

        // Close the connection
        sslSocket.close();
        sslServerSocket.close();
    }
}