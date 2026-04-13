import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32148_SocketServer_A03 {
    private static final int DEFAULT_PORT = 12345;
    private int port;

    public java_32148_SocketServer_A03() {
        this.port = DEFAULT_PORT;
    }

    public java_32148_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here we're injecting a SQL query into the message to demonstrate security
            String message = "SELECT * FROM users WHERE username = '" + socket.getRemoteSocketAddress() + "'";

            // Send the message back to the client
            socket.getOutputStream().write(message.getBytes());
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer().start();
    }
}