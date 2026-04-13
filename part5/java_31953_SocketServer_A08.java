import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31953_SocketServer_A08 {
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started on port: " + SERVER_PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here, we are using SSLSocket for securing the communication. 
                // You can use other SSLSocket implementation for different security requirements.
                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress());
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();

                // Here, we are assuming that the server has a client that successfully connects. 
                // In a real-world scenario, you would need to validate the client certificate.
                // You can use SSLContext for different cipher suites and key sizes.
                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new X509Certificate[]{sslSocket.getRemoteCertificate()}, null);

                // Now, you can use sslContext for the rest of the communication.
                // For example, you can use sslContext.getProtocol() for the protocol you are using.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}