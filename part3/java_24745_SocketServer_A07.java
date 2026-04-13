import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_24745_SocketServer_A07 {

    private static final int PORT = 8080;
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        Executor executor = Executors.newCachedThreadPool();

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
        serverSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client authentication...");

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            executor.execute(new Runnable() {
                public void run() {
                    // Handles client request
                    try {
                        // Read request from client

                        // TODO: Handle request

                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}