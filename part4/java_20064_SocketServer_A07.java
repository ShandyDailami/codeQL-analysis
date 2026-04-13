import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_20064_SocketServer_A07 {

    private static final int PORT = 8443;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(50);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        sslServerSocket.setNeedClientAuth(true);

        sslServerSocket.setEnabledProtocols(new String[] {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});

        while (true) {
            Socket clientSocket = sslServerSocket.accept();
            System.out.println("Client connected!");
            executor.execute(new SocketHandler(clientSocket));
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket clientSocket;

        public java_20064_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // handle the client
        }
    }
}