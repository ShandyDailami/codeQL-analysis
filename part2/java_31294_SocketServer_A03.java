import java.io.*;
import java.net.*;

public class java_31294_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Create thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_31294_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Receive a message from the client
                String message = in.readLine();

                // Process the message (e.g., print the received message)
                System.out.println("Received: " + message);

                // Send a response back to the client
                out.println("Server: Hello, client!");

                // Close the connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}