import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_18327_SocketServer_A08 {
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEY_PASSWORD = "password";

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = SocketServer.class.getClassLoader().getResourceAsStream(SERVER_KEYSTORE);
            keyStore.load(resourceAsStream, SERVER_KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, SERVER_KEY_PASSWORD.toCharArray());

            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket.createSecureSocket();
            sslServerSocket.setKeyManagers(keyManagerFactory.getKeyManagers());

            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            clientSocket.startHandshake();

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Server received: " + message);

            dos.writeUTF("Server received your message");
            dos.flush();

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}