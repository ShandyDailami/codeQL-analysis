import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03430_SocketServer_A07 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        // Create a server socket and listen for connections
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Accept a new connection
                Socket socket = server.accept();

                // Create a new thread for handling this connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
    }

    // A client handler thread for handling individual client connections
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_03430_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // This is a placeholder and doesn't actually do anything
            // You'd want to add code here to handle client requests
            // and send responses back to the client
        }
    }
}