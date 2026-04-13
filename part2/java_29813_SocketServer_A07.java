import java.net.*;
import java.io.*;

public class java_29813_SocketServer_A07 {

    public static void main(String[] args) throws IOException {

        int port = 6000;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        // Infinite loop to keep the server running until explicitly stopped
        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication here
                if (authenticate(socket)) {
                    // If authentication succeeds, start a new thread to handle the client
                    new HandleClient(socket).start();
                } else {
                    System.out.println("Authentication failed. Closing connection with client.");
                    socket.close();
                }
            } catch (IOException ex) {
                server.close();
                System.out.println("Server interrupted. Exiting to clean up resources.");
                break;
            }
        }

        server.close();
    }

    // Method to perform authentication
    private static boolean authenticate(Socket socket) throws IOException {
        // Place your authentication logic here. For simplicity, we'll just return true
        return true;
    }

    // Class to handle client connections
    private static class HandleClient extends Thread {
        private Socket socket;

        HandleClient(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Handle client messages here
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Thank you for connecting");
                }

                socket.close();
            } catch (IOException ex) {
                // Handle exceptions here
            }
        }
    }
}