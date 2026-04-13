import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class java_34172_SocketServer_A08 {
    public static void main(String[] args) throws IOException, CertificateException {
        // Enable BouncyCastle for SSL
        java.security.Security.addProvider(new BouncyCastleProvider());

        boolean useSsl = true;
        ServerSocket serverSocket = null;

        if (useSsl) {
            serverSocket = new SSLServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
        } else {
            serverSocket = new ServerSocket(8080);
        }

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            if (useSsl) {
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.startHandshake();
                sslSocket.getSession().getCertificate().checkValidity();
            }

            // start handling the client connection here
        }
    }
}