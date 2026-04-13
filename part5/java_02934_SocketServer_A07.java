import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02934_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a server socket and listen on the designated port
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            // Accept a client socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Create a new thread to handle the communication with the client
            HandleClientThread thread = new HandleClientThread(clientSocket);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}