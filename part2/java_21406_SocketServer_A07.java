import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_21406_SocketServer_A07 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            KeyStore truststore = KeyStore.getInstance("JKS");
            truststore.load(new FileInputStream(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444, keystore, truststore);

            System.out.println("Waiting for client on port 4444");

            // accept client connection
            socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuth(true);

            // read the handshake
            SSLHandshake sh = socket.getHandshake();
            if (sh instanceof SSLHandshake) {
                SSLCertificate cert = socket.getCertificate();
                System.out.println("Client: " + ((SSLCertificate)cert).getIssuerDN());
            }

            // write response
            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);
            pw.println("Hello from server");
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}