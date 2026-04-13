import java.net.*;
import java.io.*;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class java_26293_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;
        SSLContext sslContext = null;

        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new X509Certificate[]{}, null);
            serverSocket = new ServerSocket(PORT);
            sslServerSocket = (SSLServerSocket) sslServerSocket.newInstance();
            sslServerSocket.bind(serverSocket);
            sslServerSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client on port " + PORT);

            SSLSocket sslSocket = null;
            while (true) {
                sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client connected from " + sslSocket.getRemoteSocketAddress());

                sslSocket.startHandshake();

                SSLCertificate cert = sslSocket.getSession().getPeerCertificate();
                System.out.println("Certificate for client: " + cert.toString());

                sslSocket.close();
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}