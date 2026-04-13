import java.io.*;
import java.net.*;
import java.util.*;

public class java_41793_SocketServer_A01 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = server.accept();
            System.out.println("Client connected!");

            // Add the client socket to the list of connected clients
            clients.add(clientSocket);

            // Handle the client in a new thread
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_41793_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read a line of text from the client
                String message = in.readLine();
                System.out.println("Received message: " + message);

                // Send a response back to the client
                out.println("Server received your message: " + message);

                // Close the connection
                clientSocket.close();
                clients.remove(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}