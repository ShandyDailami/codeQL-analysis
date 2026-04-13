import java.io.*;
import java.net.*;

public class java_16056_SocketServer_A07 {

    public static void main(String[] args) throws IOException {

        // Create a new server socket at port 9876
        ServerSocket server = new ServerSocket(9876);
        System.out.println("Server started at port 9876");

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();

            // Start a new thread for handling the client
            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {

        private Socket client;

        public java_16056_SocketServer_A07(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                // Create input and output streams
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream writer = new DataOutputStream(client.getOutputStream());

                // Read username from client
                String username = reader.readLine();
                System.out.println("Client " + username + " connected.");

                // Authenticate username
                if (auth(username)) {
                    writer.write("Welcome " + username + "! Connection successful.\n".getBytes());
                } else {
                    writer.write("Authentication failed! Connection denied.\n".getBytes());
                    client.close();
               
                    // Close the client connection
                    client.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean auth(String username) {
            // This is a simple auth check. For a real-world application, consider using SSL/TLS for secure authentication.
            return "admin".equals(username);
        }
    }
}