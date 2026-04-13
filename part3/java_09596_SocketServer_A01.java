import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_09596_SocketServer_A01 {

    private static final String CLIENT_ID = "Client";
    private static final String SERVER_KEYSTORE = "server.jks";
    private static final String SERVER_TRUSTSTORE = "server-truststore.jks";
    private static final String SERVER_PASSWORD = "server";

    private static final int PORT = 8888;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(CLIENT_ID + " connected");
                SSLSocket sslSocket = (SSLSocket) clientSocket.createChannel();
                sslSocket.setNeedClientAuth(true);

                // Set the keys and truststores
                sslSocket.setEnabledKeys(SERVER_KEYSTORE);
                sslSocket.setEnabledTruststores(SERVER_TRUSTSTORE);

                // Set the passwords
                sslSocket.setPassword(SERVER_PASSWORD);

                executor.execute(new ClientHandler(sslSocket, CLIENT_ID));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private final SSLSocket sslSocket;
        private final String clientId;

        ClientHandler(SSLSocket sslSocket, String clientId) {
            this.sslSocket = sslSocket;
            this.clientId = clientId;
        }

        @Override
        public void run() {
            // TODO: handle client connection
            // You can use the sslSocket object to send/receive data
        }
    }
}