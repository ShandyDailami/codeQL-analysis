import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37203_SocketServer_A03 {

    private static final int PORT = 1234;
    private static final String ANSWER = "Hello, client!";

    public static void main(String[] args) {
        // create a server socket
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                // accept a client connection
                Socket client = server.accept();
                System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

                // create a thread for each client connection
                new ClientHandler(client).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }

    // a thread for handling a client connection
    private static class ClientHandler extends Thread {

        private final Socket client;

        public java_37203_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // process the client request
            try (client) {
                // read the client request
                java.io.BufferedReader reader = new java.io.BufferedReader(client.getInputStream()
                        .reader());
                // send a response
                client.getOutputStream().write((ANSWER + "\r\n").getBytes());
                System.out.println("Sent response to client");
            } catch (IOException ex) {
                System.out.println("Error handling client connection: " + ex.getMessage());
            }
        }
    }
}