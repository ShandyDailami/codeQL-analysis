import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_18870_SocketServer_A07 {
    private static final String CLIENT_KEY_STORE = "client.jks";
    private static final String CLIENT_KEY_PASSWORD = "password";
    private static final String SERVER_KEY_STORE = "server.jks";
    private static final String SERVER_KEY_PASSWORD = "password";
    private static final String ALGORITHM = "SunEC";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9001);
        serverSocket.setNeedClientAuth(true);

        KeyStore clientStore = KeyStore.getInstance("JKS");
        clientStore.load(new FileInputStream(CLIENT_KEY_STORE), CLIENT_KEY_PASSWORD.toCharArray());

        KeyStore serverStore = KeyStore.getInstance("JKS");
        serverStore.load(new FileInputStream(SERVER_KEY_STORE), SERVER_KEY_PASSWORD.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(ALGORITHM);
        keyManagerFactory.init(clientStore, CLIENT_KEY_PASSWORD.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, null, null);

        Socket socket = serverSocket.accept();
        SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
        // continue your processing here
        }
    }
}