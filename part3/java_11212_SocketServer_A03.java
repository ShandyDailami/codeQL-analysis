import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_11212_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setNeedClientAuth(true);

            // Create a new SSLSocket for each request
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            // Perform some operations with the SSLSocket object
            OutputStream out = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, World!");

            // Close the connection
            sslSocket.close();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}