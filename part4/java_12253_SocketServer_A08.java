import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12253_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocket server = (SSLServerSocket) serverSocket.getShared();

            // Create a key store and trust store for SSL
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(SocketServer.class.getResourceAsStream("/client.jks"), "password".toCharArray());
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(SocketServer.class.getResourceAsStream("/server.jks"), "password".toCharArray());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, trustStore, null);

            server = (SSLServerSocket) sslContext.getServerSocket(PORT);
            server.setNeedClientAuth(true);

            System.out.println("Waiting for client on port: " + PORT);
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Continue with communication...

        } finally {
            serverSocket.close();
        }
    }
}