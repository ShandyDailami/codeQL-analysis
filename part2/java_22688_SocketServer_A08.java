import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_22688_SocketServer_A08 {
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        SSLContext sslContext = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("src/main/resources/keystore.jks"), PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("src/main/resources/truststore.jks"), PASSWORD.toCharArray());

            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustStore, null);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        try (SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocket;
             SSLSocket socket = (SSLSocket) sslSocket;
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                out.println("Echo: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}