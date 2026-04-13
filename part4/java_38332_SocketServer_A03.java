import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_38332_SocketServer_A03 {

    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEYTOOL_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYTOOL_PASSWORD = "your_keystore_password";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);
        SSLServerSocket sslServer = (SSLServerSocket) serverSocket;

        sslServer.setNeedClientAuth(true);

        // Load the keystore and keytool
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, KEYTOOL_PASSWORD.toCharArray());

        sslServer.setKeyManagers(keyManagerFactory.getKeyManagers());

        while (true) {
            Socket socket = sslServer.accept();
            new SocketHandler(socket).start();
        }
    }

    private static class SocketHandler extends Thread {
        private Socket socket;

        public java_38332_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // handle client
        }
    }
}