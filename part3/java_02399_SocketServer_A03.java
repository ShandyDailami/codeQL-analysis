import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_02399_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        Socket connection = null;

        // Load the certificate and key for SSL
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());
        SSLServerSocket sslSocket = new SSLServerSocket(5000, (SSLServerSocket) socket, keyStore, "password".toCharArray());

        sslSocket.setNeedClientAuth(true);
        sslSocket.setEnabledCipherSuites(
        "SSL_RSA_WITH_RC4_128",
        "SSL_RSA_WITH_RC4_8",
        "SSL_DSS_WITH_RC4_128",
        "SSL_DSS_WITH_RC4_8");

        while (true) {
            connection = sslSocket.accept();
            System.out.println("Connection accepted from " + connection.getRemoteSocketAddress());

            // Send and receive messages
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            String message = in.readLine();
            System.out.println("Received message: " + message);
            out.writeBytes("Message received\n");
            connection.close();
        }
    }
}