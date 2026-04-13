import java.net.*;
import java.io.*;
import java.util.*;

public class java_21446_SocketServer_A07 {

    // Define the port we'll listen on
    private static final int PORT = 8888;

    // Our main method
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Handle the new client
            new ClientHandler(socket).start();
        }
    }

    // Handler for a single client
    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_21446_SocketServer_A07(Socket socket) {
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
                // Read message from client
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Broadcast the message to all clients
                    out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}