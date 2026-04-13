import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_10377_SocketServer_A08 {

    private static final String SSL_PORT = "8443";
    private static final String SERVER_PORT = "8444";

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore","server.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","password");
        System.setProperty("javax.net.ssl.trustStore","client.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","password");

        runServer(SERVER_PORT);
    }

    private static void runServer(String port) {
        int portNumber = Integer.parseInt(port);

        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(portNumber)) {
            System.out.println("Server started on port " + portNumber);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                SSLSocket sslSocket = (SSLSocket) socket.createChannel();
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();

                System.out.println("Handshake completed");
            }
        } catch (IOException e) {
            System.out.println("Failed to accept connection on port " + portNumber);
            e.printStackTrace();
        }
    }
}