import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_13240_SocketServer_A07 {
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String ALGORITHM = "SSLv3";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        try {
            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
            keyManagerFactory.init(clientKeystore, CLIENT_KEYSTORE_PASSWORD.toCharArray());

            KeyStore serverKeystore = KeyStore.getInstance("JKS");
            serverKeystore.load(new FileInputStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD.toCharArray());
            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance("SunKSAPI");
            keyFactory.init(serverKeystore, SERVER_KEYSTORE_PASSWORD.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyManagers(keyFactory.getKeyManagers());

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client authentication...");
            socket = serverSocket.accept();
            System.out.println("Client authenticated successfully!");

            SSLSocket sslSocket = (SSLSocket) socket.createChannel();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setEnabledProtocols(new String[]{"SSLv3"});
            sslSocket.startHandshake();
            System.out.println("Handshake completed successfully!");

            // Continue with your business logic...

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }
}