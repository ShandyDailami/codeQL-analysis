import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28210_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Handle the socket connection here
            // For example, create a new thread for each connection
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Here, you can read data from the client, process it, and send back data to the client
            // For example, create a new thread for each read operation
            new Thread(() -> {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                while (bytesRead != -1) {
                    // Process the received data here
                    System.out.println("Received data: " + new String(buffer, 0, bytesRead));

                    bytesRead = socket.getInputStream().read(buffer);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}