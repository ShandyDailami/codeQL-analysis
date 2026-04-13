import java.io.*;
import java.net.*;

public class java_31886_SocketServer_A01 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and wait for a connection
            serverSocket = new ServerSocket(8189);
            System.out.println("Server is listening on port 8189");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for the connection
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the ServerSocket and clean up
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class HandlerThread extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_31886_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request, response;

            // Read the request from the client
            try {
                request = reader.readLine();
                System.out.println("Received: " + request);

                // Check for username/password authentication
                if (request.contains("username=" + USERNAME) && request.contains("password=" + PASSWORD)) {
                    response = "OK";
                } else {
                    response = "FAIL";
                }

                // Send the response back to the client
                writer.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Close the connection
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}