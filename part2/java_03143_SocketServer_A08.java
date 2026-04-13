import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_03143_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();

        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
        sslServerSocket.setNeedClientAuth(true);

        // Create a new SSLSocket for each client that connects
        sslSocket = (SSLSocket) sslServerSocket.accept();

        // Setup SSL Input/Output streams
        SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
        SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

        // Get client's SSLCertificate
        SSLCertificate clientCert = (SSLCertificate) sslSocket.getRemoteCertificate();

        // Print out client's SSLCertificate
        System.out.println("Client SSLCertificate: " + clientCert.toString());

        // Close the socket and streams
        sslOut.close();
        sslIn.close();
        sslSocket.close();
        sslServerSocket.close();
    }
}