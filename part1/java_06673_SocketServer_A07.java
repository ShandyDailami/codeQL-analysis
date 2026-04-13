import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06673_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Secure the connection by using SSL/TLS
                // Start SSLSocketServer for client communication
                // SSLSocket ssl = (SSLSocket) socket.createChannel(socket.getChannel().getAcceptor());
                // ssl.startHandshake();

                // Create new SocketServerThread for handling client requests
                SocketServerThread thread = new SocketServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketServerThread extends Thread {
    private Socket socket;

    public java_06673_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client requests
        // ...
    }
}