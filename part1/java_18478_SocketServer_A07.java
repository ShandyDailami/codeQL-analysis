import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18478_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 1234; // choose a port

        // Create a server socket
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Wait for a client to connect
            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected!");

                // Handle the client in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + port);
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_18478_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // You can use a library like Netty or write your own code for socket communication
            // For example, you can use a BufferedReader and PrintWriter to read and write data

            // Here's a simple example of reading from a client
            try (Socket client = socket;
                 java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
                 java.io.PrintWriter writer = new java.io.PrintWriter(socket.getOutputStream(), true)) {

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    // Process the request
                    // For example, check if the request contains a password
                    if (request.contains("password")) {
                        writer.println("Sorry, but I can't accept the password");
                    } else {
                        writer.println("Hello, client!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}