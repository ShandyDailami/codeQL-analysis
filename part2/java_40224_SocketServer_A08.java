import java.io.*;
import java.net.*;

public class java_40224_SocketServer_A08 {
    private static int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Handling the request and response in a separate thread
            new Handler(socket).start();
        }
    }

    static class Handler extends Thread {
        private Socket socket;
        BufferedReader in;
        PrintWriter out;

        public java_40224_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    // Process the received message
                    System.out.println("Received: " + message);
                    // Assume a critical operation that might fail (e.g., integrity failure)
                    // if the message contains a specific word
                    if (message.contains("fail")) {
                        throw new SecurityException("Integrity Failure");
                    }
                    // Send a response back to the client
                    out.println("Server response: " + message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected.");
            } catch (SecurityException e) {
                System.out.println("Caught SecurityException: " + e.getMessage());
                // Close the socket and the streams
                close();
            }
        }

        private void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}