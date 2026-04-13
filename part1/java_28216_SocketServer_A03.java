import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28216_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        // Start listening for incoming connections
        System.out.println("Server is listening on port 12345...");

        while (true) {
            // Accept a new connection
            Socket clientSocket = serverSocket.accept();

            // Start a new thread for handling the client
            new HandlerThread(clientSocket).start();
        }
    }

    // A separate thread for handling a client
    static class HandlerThread extends Thread {
        Socket clientSocket;

        public java_28216_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            // Get input and output streams
            try (java.io.BufferedReader in = new java.io.BufferedReader(clientSocket.getInputStream());
                 java.io.PrintWriter out = new java.io.PrintWriter(clientSocket.getOutputStream(), true)) {

                // Read a message from the client
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Reply with a welcome message
                out.println("Welcome to the server!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}