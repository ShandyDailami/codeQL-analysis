import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17615_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Handle the connection in a separate thread
                new Handler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handler class to handle communication with a client
    static class Handler extends Thread {
        private Socket socket;

        public java_17615_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Code here can use only standard Java libraries and is not using external frameworks
            // For example, this code could use the BufferedReader and PrintWriter classes
            try (java.io.BufferedReader in = new java.io.BufferedReader(socket.getInputStream());
                 java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true)) {

                // Read the message from the client
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Send a response back to the client
                out.println("Hello, client!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}