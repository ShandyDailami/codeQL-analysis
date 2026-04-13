import java.io.*;
import java.net.*;

public class java_14166_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Create a server socket on port 8080
            while (true) { // Infinite loop to accept new clients
                Socket clientSocket = serverSocket.accept(); // Wait for a client to connect
                System.out.println("A client has connected");

                // Handle the client socket in a separate thread
                Thread thread = new Thread(new SocketHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {

        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_14166_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close(socket, reader, writer);
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) { // Read message from client
                    System.out.println("Received: " + message);
                    // Send a response back to the client
                    writer.println("Server says: " + message);
                }
            } catch (IOException e) {
                close(socket, reader, writer);
                e.printStackTrace();
            }
        }

        private void close(Socket socket, BufferedReader reader, PrintWriter writer) {
            try {
                reader.close();
                writer.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}