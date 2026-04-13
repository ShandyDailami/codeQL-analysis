import java.io.*;
import java.net.*;

public class java_39080_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        // Create a server socket and listen for client connections
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create a new thread for the client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    // Inner class to handle client connections
    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;

        public java_39080_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams for communication
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}