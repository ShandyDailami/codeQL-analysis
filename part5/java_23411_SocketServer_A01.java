import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class java_23411_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        runServer(1234);
    }

    public static void runServer(int port) throws Exception {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(port);
            socket.setReuseAddress(true);

            // Load SSL certificate and trust it
            TrustManagerFactory tmf = TrustManagerFactory.fromTruststore("truststore.jks", "mytruststorepassword");

            SSLServerSocketFactory sslSocketFactory = (SSLServerSocketFactory) socket.getSocketFactory();
            sslSocketFactory.setTrustManager(tmf.getTrustManagers());

            while (true) {
                System.out.println("Waiting for client connection...");
                SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(socket.getInetAddress(), port);
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();

                System.out.println("Client connected: " + sslSocket.getRemoteSocketAddress());

                // Here you can read the data from the socket.
                // For simplicity, we're just echoing back the data.
                // For a real application, you would also handle client requests here.
                while ((socket = sslSocket.accept()) != null) {
                    System.out.println("Received message: " + socket.getInputStream().readUTF());
                    socket.getOutputStream().writeUTF("OK");
                    socket.getOutputStream().flush();
                }
            }
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}