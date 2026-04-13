import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_11646_SocketServer_A07 {

    private static final String SSL_SERVER_KEYSTORE = "server.jks";
    private static final String SSL_SERVER_KEYSTORE_PASSWORD = "password";
    private static final String SSL_CLIENT_KEYSTORE = "client.jks";
    private static final String SSL_CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SSL_TRUSTSTORE = "truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            KeyStore serverKeystore = KeyStore.getInstance("JKS");
            serverKeystore.load(new FileInputStream(SSL_SERVER_KEYSTORE), SSL_SERVER_KEYSTORE_PASSWORD.toCharArray());

            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(SSL_CLIENT_KEYSTORE), SSL_CLIENT_KEYSTORE_PASSWORD.toCharArray());

            KeyStore truststore = KeyStore.getInstance("JKS");
            truststore.load(new FileInputStream(SSL_TRUSTSTORE), SSL_TRUSTSTORE_PASSWORD.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(serverKeystore, clientKeystore, truststore);
            serverSocket.setSSLContext(sslContext);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createChannel();
                sslSocket.setNeedClientAuth(true);
                sslSocket.setUseClientMode(true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                String userInput;
                while ((userInput = in.readLine()) != null) {
                    System.out.println("Received: " + userInput);
                    out.println("Server received: " + userInput);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}