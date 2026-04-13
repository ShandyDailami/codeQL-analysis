import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_05961_SocketServer_A08 {
    public static void main(String[] args) throws IOException, CertificateException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8090);

        sslServerSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client authentication");
        InetSocketAddress addr = (InetSocketAddress) sslServerSocket.getInetAddress();
        System.out.println("Server listening on port " + addr.getPort() + " for " + addr.getHostName());

        while (true) {
            SSLServerSocket clientSocket = (SSLServerSocket) sslServerSocket.accept();
            System.out.println("Connection accepted from " + clientSocket.getRemoteSocketAddress());

            // Proceed with client handshake and communication here...

            clientSocket.close();
        }
    }
}