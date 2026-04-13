import java.net.*;
import java.io.*;

public class java_28543_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and a new thread for handling client connections
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A new client connected!");
            // Create a new thread to handle communication with the client
            new ClientHandler(clientSocket).start();
        }
    }

    // Handles communication with a client
    static class ClientHandler extends Thread {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        public java_28543_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        // Sends a message to the client
        public void send(String message) {
            out.println(message);
        }

        // Closes the connection
        public void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Handles incoming messages from the client
        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Send a reply to the client
                    send("Hello, client!");
                }
            } catch (IOException e) {
                close();
            }
        }
    }
}