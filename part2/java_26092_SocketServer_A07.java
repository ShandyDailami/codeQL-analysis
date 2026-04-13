import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_26092_SocketServer_A07 {
    private static final String CLIENT_KEYSTORE = "path_to_your_keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "path_to_your_server_keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            KeyStore serverKeystore = KeyStore.getInstance("JKS");
            serverKeystore.load(new FileInputStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD.toCharArray());
            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(serverKeystore, SERVER_KEYSTORE_PASSWORD.toCharArray());
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            serverSocket.setNeedClientAuth(true);
            serverSocket.setKeyManagers(keyManagers);

            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Client, you are now connected to the server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}