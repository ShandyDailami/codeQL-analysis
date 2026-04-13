import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_32155_SocketServer_A01 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_PASSWORD = "password";

    public static void main(String[] args) {
        runServer(12345, true); // Change port number as needed
    }

    private static void runServer(int port, boolean ssl) {
        try {
            ServerSocket serverSocket = null;

            if (ssl) {
                SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
                serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

                serverSocket.setNeedClientAuthentication(true);
                serverSocket.setEnabledCipherSuites(sslCipherSuites);

                // Set the custom KeyStore
                serverSocket.setKeyStore(KeyStore.getInstance("JKS"), KEYSTORE_PASSWORD.toCharArray());
                serverSocket.setKeyStorePassword(KEYSTORE_PASSWORD);

                // Set the custom TrustStore
                serverSocket.setTrustStore(KeyStore.getInstance("JKS"), KEYSTORE_PASSWORD.toCharArray());
                serverSocket.setTrustStorePassword(KEYSTORE_PASSWORD);
            } else {
                serverSocket = new ServerSocket(port);
            }

            while (true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                // Send a welcome message to the client
                dataOutputStream.writeUTF("Welcome to the server!");

                // Read the message from the client
                String message = dataInputStream.readUTF();
                System.out.println("Received message: " + message);

                // Close the connection
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}