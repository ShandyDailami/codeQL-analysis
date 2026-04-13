import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17644_SocketServer_A07 {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        System.out.println("Server is listening on port " + SERVER_PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Here you would typically use a thread to handle the communication
            // with the client, but since this is a simple server, we'll just echo the data back.
            new Thread(() -> {
                try {
                    // Read from the socket
                    byte[] bytes = new byte[1024];
                    int length = socket.getInputStream().read(bytes);
                    if (length != -1) {
                        // Write to the socket
                        socket.getOutputStream().write(bytes, 0, length);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}