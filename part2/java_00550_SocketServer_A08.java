import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class java_00550_SocketServer_A08 {
    private static final Logger LOGGER = Logger.getLogger(SecureServer.class.getName());

    public static void main(String[] args) {
        try {
            // Set up Bouncy Castle provider
            System.setProperty("javax.net.ssl.pemKeyAlias", "sslkey");
            System.setProperty("javax.net.ssl.pemPassword", "password");
            System.setProperty("javax.net.ssl.keyStore", "path_to_your_keystore.jks");
            System.setProperty("javax.net.ssl.trustStore", "path_to_your_truststore.jks");
            System.setProperty("javax.net.ssl.SSLContextFactory", "org.bouncycastle.jsse.provider.BouncyCastleSSLContextFactory");

            // Create a SSL Server Socket
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);

                // Get the input and output streams
                OutputStream out = sslSocket.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

                // Read and write
                while (true) {
                    String line = in.readLine();
                    if (line == null || line.equals("exit")) {
                        break;
                    }
                    out.write(line.getBytes());
                    out.newLine();
                    out.flush();
                }

                sslSocket.close();
            }
        } catch (IOException e) {
            LOGGER.severe("Error: " + e.getMessage());
        }
    }
}