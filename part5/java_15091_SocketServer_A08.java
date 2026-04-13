import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_15091_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            // Load the certificate and private key
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(10001);
            socket = (SSLSocket) serverSocket.accept();

            // Perform a handshake to confirm the client's identity
            SSLSession session = socket.getSession();
            SSLPeerUnverifiedCertificate[] peerCert = session.getPeerCertificateVerification(null);

            System.out.println("Verified peer certificate: " + peerCert[0].toString());

            // Write a message to the client
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, Client!");
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}