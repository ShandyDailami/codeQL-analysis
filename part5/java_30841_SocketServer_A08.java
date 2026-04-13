import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_30841_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            // Create a SSLServerSocket that listens on port 8443
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);

            sslServerSocket.setNeedClientAuth(true);

            // Accept a connection
            sslSocket = (SSLSocket) sslServerSocket.accept();

            // Write the accepted message
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            out.println("Secure Connection Successfully Established");

        } catch (SSLException e) {
            System.out.println("Exception caught when trying to listen on port 8443 : " + e.getMessage());
            e.printStackTrace();
        }

        // Close the connection
        sslSocket.close();
        sslServerSocket.close();
    }
}