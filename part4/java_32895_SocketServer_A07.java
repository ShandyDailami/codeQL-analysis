import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_32895_SocketServer_A07 {

    private static final String SSL_PORT = "1234";
    private static final String SERVER_KEYSTORE_PATH = "server.jks";
    private static final String SERVER_KEYSTORE_PASSWORD = "serverpass";
    private static final String CLIENT_KEYSTORE_PATH = "client.jks";
    private static final String CLIENT_KEYSTORE_PASSWORD = "clientpass";
    private static final String KEY_ALIAS = "alias";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            serverSocket.setNeedClientAuth(true);
            serverSocket.setCertificateVerificationParams(KEY_ALIAS, new File(CLIENT_KEYSTORE_PATH), CLIENT_KEYSTORE_PASSWORD);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Socket socket = null;
        try {
            socket = serverSocket.accept();
            socket.setNeedClientAuth(true);
            socket.getCertificate().checkValidity();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        SSLSocket sslSocket = (SSLSocket) socket.getSocket();
        sslSocket.setNeedClientAuth(true);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            out.println("Server says: Hello, client!");
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = null;

        SSLServerSocket sslServerSocket = null;
        KeyStore keyStore = null;

        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

        sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        keyStore.load(new FileInputStream(SERVER_KEYSTORE_PATH), SERVER_KEYSTORE_PASSWORD.toCharArray());

        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT), null, keyStore, new File("/tmp"));

        return sslServerSocketFactory;
    }

}