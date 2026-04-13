import java.net.*;
import java.io.*;
import javax.net.ssl.*;

public class java_16277_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setEnabledCipherSuites(new String[]{"SSL_RSA_WITH_RC4_128", "SSL_RSA_EXPORT_4096"});
            serverSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client on port " + serverSocket.getPort());

            while (true) {
                socket = (SSLSocket) serverSocket.accept();
                socket.startHandshake();
                System.out.println("Client connected on port " + socket.getLocalPort());

                OutputStream out = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello client, you are connected to " + socket.getLocalSocketAddress());

                SSLCertificate cert = socket.getSSLCertificate();
                System.out.println("Client Certificate: " + cert.toString());
            }
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}