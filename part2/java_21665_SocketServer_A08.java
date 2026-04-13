import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21665_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 12345.
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            // Wait for a client to connect.
            Socket clientSocket = serverSocket.accept();

            // Handle the client connection.
            new ClientHandler(clientSocket);
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_21665_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
            new Thread(this).start();
        }

        @Override
        public void run() {
            // TODO: Handle the client connection.
            // This is a placeholder for your client handling code.
            // You'll need to replace this with your actual code for handling client connections.
        }
    }
}