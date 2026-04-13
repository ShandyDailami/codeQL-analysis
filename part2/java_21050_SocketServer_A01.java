import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21050_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Accepted new client: " + clientSocket.getRemoteSocketAddress());

                // Perform security sensitive operations here
                // For example, verifying the client's identity or authorizing access

                // Start a new thread to handle communication with the client
                new HandleClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static class HandleClientThread extends Thread {
        private Socket clientSocket;

        public java_21050_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Perform communication with the client
            // For example, reading data from the client, sending data back to the client, or closing the connection
        }
    }
}