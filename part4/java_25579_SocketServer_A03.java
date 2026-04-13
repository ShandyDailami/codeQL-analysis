import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_25579_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Start a new server on port 12345
        java.net.ServerSocket server = new java.net.ServerSocket(12345);

        // Listen for incoming connections
        while (true) {
            Socket client = server.accept();

            // Create a new thread to handle the client request
            Thread handler = new Thread(new ClientHandler(client));
            handler.start();
        }
    }

    // Define a client handler that creates a new thread for each client
    static class ClientHandler implements Runnable {
        private final Socket client;

        public java_25579_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Create a new reader for the client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                
                // Create a new writer for the client
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Read the client's message
                String message = in.readLine();
                
                // Send a response back to the client
                out.println("Server received: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}