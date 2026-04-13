import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_04532_SocketServer_A03 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            KeyManagementStrategy kmStrategy = new KeyManagementStrategyImpl(keystore, KEY_PASSWORD);
            SSLServerSocketFactory sslServerSocketFactory = kmStrategy.getSslServerSocketFactory();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            System.out.println("Server SSL initialized.");

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected.");

                SSLSocketReader reader = new SSLSocketReader(clientSocket);
                SSLSocketWriter writer = new SSLSocketWriter(clientSocket);

                BufferedReader in = new BufferedReader(reader);
                DataOutputStream out = new DataOutputStream(writer);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client says: " + message);
                    out.write("Server says: " + message + "\n");
                    out.flush();
                }
                clientSocket.close();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}