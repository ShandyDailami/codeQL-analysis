import java.io.*;
import java.net.*;

public class java_06907_SocketServer_A07 {

    private static int port = 6666;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client: " + e);
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_06907_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dis = new DataInputStream(input);

                // Read the auth token from the client
                String authToken = dis.readUTF();

                // Check if the token is valid (simulated here)
                if (isValidAuthToken(authToken)) {
                    // If valid, send a response back to the client
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF("Auth successful");
                } else {
                    // If not valid, send an error message back to the client
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF("Auth failure");
                }

                // Close the connection
                socket.close();
            } catch (IOException e) {
                System.out.println("Error handling client: " + e);
            }
        }

        // Simulate the isValidAuthToken method here
        private boolean isValidAuthToken(String token) {
            // Here you can add the logic to check if the token is valid
            // For now, we just return true in this simulation
            return true;
        }
    }
}