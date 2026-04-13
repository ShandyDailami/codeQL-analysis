import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_09768_SocketServer_A07 {

    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE = "truststore";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try (SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080)) {
            SSLEngine engine = serverSocket.getSSLEngine();
            engine.setUseClientMode(true);
            engine.setNeedClientAuth(true);
            // Importing Certificates
            engine.setNeedServerAuth(true);
            engine.setKeyStore(CLIENT_KEYSTORE, CLIENT_KEYSTORE_PASSWORD);
            engine.setTrustStore(TRUSTSTORE, TRUSTSTORE_PASSWORD);
            // Importing Certificates
            engine.setKeyStorePassword(SERVER_KEYSTORE_PASSWORD);
            engine.setKeyManagers(CLIENT_KEYSTORE, CLIENT_KEYSTORE_PASSWORD);
            // Importing Certificates
            engine.setTrustStorePassword(TRUSTSTORE_PASSWORD);
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        Handler(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            // ... handle connection, read from socket, write to socket, close connection
        }
    }
}