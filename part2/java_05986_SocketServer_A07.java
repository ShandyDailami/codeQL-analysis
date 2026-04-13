import java.io.*;
import java.net.*;
import java.util.*;

public class java_05986_SocketServer_A07 {

    // Listening port for server.
    private static final int SERVER_PORT = 8080;

    // Buffer size.
    private static final int BUFFER_SIZE = 1024;

    // Thread to handle client connections.
    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_05986_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Reading data from the client.
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);

                    // Simulating authentication failure.
                    if (message.equals("fail")) {
                        writer.writeBytes("HTTP/1.1 401 Unauthorized\r\n\r\n");
                        writer.flush();
                        System.out.println("Auth failure, sending 401 Unauthorized response.");
                        break;
                    }

                    // Simulating authentication success.
                    if (message.equals("success")) {
                        writer.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                        writer.flush();
                        System.out.println("Auth success, sending 200 OK response.");
                        break;
                    }
                }

                // Closing connection.
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Creating server socket and accepting client connections.
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is listening on port: " + SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Creating new thread for handling client.
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}