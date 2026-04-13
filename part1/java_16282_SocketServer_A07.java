import java.io.*;
import java.net.*;

public class java_16282_SocketServer_A07 {

    private static int port = 5000;

    public static void main(String[] args) throws IOException {

        // Create a server socket and listen on the given port
        ServerSocket server = new ServerSocket(port);

        System.out.println("Server started on port: " + port);

        // Accept a client connection
        Socket client = server.accept();

        System.out.println("Client connected: " + client.getInetAddress().getHostAddress());

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // Start a new thread for communication
        Thread commThread = new Thread(new ClientCommunication(client, in, out));
        commThread.start();
    }

    // Inner class for handling client communication
    static class ClientCommunication implements Runnable {

        private Socket client;
        private BufferedReader in;
        private PrintWriter out;

        public java_16282_SocketServer_A07(Socket client, BufferedReader in, PrintWriter out) {
            this.client = client;
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                // Read a message from the client
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Check if the message is authenticated
                if (message.equals("auth")) {
                    // If the message is authenticated, reply with a success message
                    out.println("auth successful");
                } else {
                    // If the message is not authenticated, reply with an error message
                    out.println("auth failed");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            // Close the client socket
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}