import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34086_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            // Handle the client socket here, for example, by creating a new thread
            new Thread(() -> handleClient(clientSocket)).start();
       
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle client communication here, for example, by reading from the socket and writing back
        // Here we're simply echoing back any data received
        try {
            byte[] bytes = new byte[1024];
            int length;
            while ((length = clientSocket.getInputStream().read(bytes)) != -1) {
                clientSocket.getOutputStream().write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the client socket
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}