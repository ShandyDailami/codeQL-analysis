import java.io.*;
import java.net.*;
import java.util.*;

public class java_14303_SocketServer_A03 {
    // Define the port on which the server will listen
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            // Accept incoming connection
            Socket socket = server.accept();

            // Create a thread for each client
            ClientHandler client = new ClientHandler(socket);
            Thread thread = new Thread(client);
            thread.start();
        }
    }

    // Handler for each client
    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_14303_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                // Receive and print client message
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Check for possible injection attacks
                    if (message.contains("test_injection")) {
                        System.out.println("Suspicious activity detected. Terminating session.");
                        out.println("Suspicious activity detected. Terminating session.");
                        socket.close();
                        return;
                    }

                    // Echo back to client
                    out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Close the socket
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}