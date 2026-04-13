import java.net.ServerSocket;
import java.net.Socket;

public class java_18579_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Here we use SSLSocket to encrypt the communication between the client and the server
            SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress());
            sslSocket.setUseClientMode(true);

            // Initiate handshake
            sslSocket.handshake();

            // Now we're done with the connection, so close the socket
            sslSocket.close();
       
        }
    }
}