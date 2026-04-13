import java.net.*;
import java.io.*;

public class java_39717_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000...");

        while (true) {
            // Accept a new client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    // Handles a single client
    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_39717_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                // Read the first line of the request
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String request = reader.readLine();
                System.out.println("Received: " + request);

                // Handle the request (for now, just send a response)
                String response = "Hello, client!";
                output.write(response.getBytes());
                output.close();

                // Close the socket
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}