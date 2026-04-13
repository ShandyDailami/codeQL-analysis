import java.io.*;
import java.net.*;

public class java_19001_SocketServer_A07 {
    private static final String AUTH_SERVER = "localhost";
    private static final int AUTH_PORT = 1234;
    private static final int SERVER_PORT = 1235;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server listening on port " + SERVER_PORT);

            while (true) {
                // Accept a client connection
                Socket client = server.accept();
                System.out.println("Connection accepted from " + client.getRemoteSocketAddress());

                // Create a data input stream for reading client requests
                DataInputStream in = new DataInputStream(client.getInputStream());
                String message = in.readUTF();

                // Perform authentication
                if (authenticate(message)) {
                    // If authentication is successful, start a new thread for handling the communication
                    Handler handler = new Handler(client);
                    Thread t = new Thread(handler);
                    t.start();
                } else {
                    // If authentication fails, close the connection
                    client.close();
                    System.out.println("Authentication failed, connection closed.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String message) {
        try {
            // Connect to the authentication server
            Socket authSocket = new Socket(AUTH_SERVER, AUTH_PORT);
            DataOutputStream out = new DataOutputStream(authSocket.getOutputStream());

            // Send the message to the authentication server
            out.writeUTF(message);
            out.flush();

            // Read the response from the authentication server
            DataInputStream authIn = new DataInputStream(authSocket.getInputStream());
            String response = authIn.readUTF();

            // Close the sockets and return the response
            authSocket.close();
            return response.equals("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class Handler implements Runnable {
        private Socket client;

        public java_19001_SocketServer_A07(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                // Create a data output stream for writing server responses
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF("Authentication successful.");
                out.flush();

                // Close the connection
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}