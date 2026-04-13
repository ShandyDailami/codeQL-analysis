import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.SSLServerKeyPair;
import javax.crypto.spec.SSLServerParameters;

public class java_24787_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;

        try {
            // Setup SSL
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("server.jks"), "password".toCharArray());

            SSLServerKeyPair keyPair = (SSLServerKeyPair) keyStore.getKeyPair(KeyStore.getDefaultAlias(), "password".toCharArray());

            SSLServerParameters sslParameters = new SSLServerParameters(
                    new String[]{"TLSv1", "TLSv2", "TLSv3"},
                    true,
                    KeyManagementStrategy.getDefaultStrategy(keyPair.getPrivateKey(), null));

            sslSocket = (SSLServerSocket) socket.createServerSocket(PORT, 50, sslParameters);
            sslSocket.setNeedClientAuth(true);

            // Accept client connections
            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslSocket.accept();
                clientSocket.setNeedClientAuth(true);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Send response
                out.write("Hello, client!".getBytes());
                out.close();

                clientSocket.close();
            }
        } finally {
            if (sslSocket != null) sslSocket.close();
            if (socket != null) socket.close();
        }
    }
}