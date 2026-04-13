import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_06760_SocketServer_A07 {
    private static final String CLIENT_IDENTIFICATION = "CLIENT_IDENTIFICATION";
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_TRUSTSTORE = "server-truststore.jks";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(SERVER_KEYSTORE), "password".toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(SERVER_TRUSTSTORE), "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, new TrustStorePasswordCallback(trustStore), new java.security.SecureRandom());

            Socket socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);

            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            out.println(CLIENT_IDENTIFICATION);
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}