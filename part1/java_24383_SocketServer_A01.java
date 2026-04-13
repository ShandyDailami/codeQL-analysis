import java.io.*;
import java.net.*;

public class java_24383_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread for handling client requests
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_24383_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Send a response
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Hello, client");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}