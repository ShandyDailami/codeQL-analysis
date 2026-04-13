import java.io.*;
import java.net.*;

public class java_11430_SocketServer_A03 {

    // Define the port for the server to listen on
    private static final int PORT = 4000;

    public static void main(String[] args) throws IOException {
        // Create a new server socket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread to handle the client communication
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    // Define a static inner class for the client handler thread
    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_11430_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read the request from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Perform some security-sensitive operation like injection
                String injectedRequest = request + " " + getClass().getClassLoader().loadClass("java.lang.String");
                System.out.println("Injected request: " + injectedRequest);

                // Send the response back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Received and processed request: " + injectedRequest);

                // Close the connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}