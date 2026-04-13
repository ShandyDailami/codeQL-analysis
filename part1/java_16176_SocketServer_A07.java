import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16176_SocketServer_A07 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here you would handle the socket and potentially start a new thread
                // for the new client connection, depending on your needs.
                // For the moment, let's just close the socket.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}