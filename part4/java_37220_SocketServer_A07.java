import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_37220_SocketServer_A07 {

    private static final String CLIENT_MESSAGE = "Welcome to the server!";
    private static final int PORT = 443; // SSL port

    public static void main(String[] args) {
        runServer(false);
    }

    private static void runServer(boolean useSsl) {
        ServerSocket serverSocket;
        if (useSsl) {
            serverSocket = createSslServerSocket(PORT);
        } else {
            serverSocket = createServerSocket(PORT);
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Send welcome message
                socket.getOutputStream().write(CLIENT_MESSAGE.getBytes());

                // Wait a brief delay before closing the connection
                Thread.sleep(1000);
                socket.close();
            } catch (IOException | InterruptedException e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            }
        }
    }

    private static ServerSocket createServerSocket(int port) {
        try {
            return new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Error creating server socket: " + e.getMessage());
            return null;
        }
    }

    private static SSLServerSocket createSslServerSocket(int port) {
        try {
            return (SSLServerSocket) new SSLServerSocket(port);
        } catch (IOException e) {
            System.out.println("Error creating SSL server socket: " + e.getMessage());
            return null;
        }
    }
}