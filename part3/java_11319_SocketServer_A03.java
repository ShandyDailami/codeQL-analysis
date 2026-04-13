import java.io.*;
import java.net.*;
import java.util.*;

public class java_11319_SocketServer_A03 {

    private static ArrayList<Socket> clients = new ArrayList<Socket>();

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(2000); // Create a ServerSocket that listens on port 2000
            System.out.println("Server started on port 2000");
            while (true) {
                Socket socket = server.accept();
                clients.add(socket);
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("IOException in server: " + ex.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        public java_11319_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Read input from the socket
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String message = dis.readUTF();

                // Perform security-sensitive operation
                String sanitizedMessage = sanitizeInput(message);

                // Write sanitized message back to the client
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(sanitizedMessage);

            } catch (IOException ex) {
                System.out.println("IOException in client handler: " + ex.getMessage());
            }
        }

        private String sanitizeInput(String input) {
            // This is a very simple example of a sanitization function
            // In a real application, the input should be sanitized in a secure way.
            // In this case, we just return the input as is.
            return input;
        }
    }
}