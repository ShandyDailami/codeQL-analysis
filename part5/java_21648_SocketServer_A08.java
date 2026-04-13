import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;

public class java_21648_SocketServer_A08 {

    private final int port;
    private boolean running = false;

    public java_21648_SocketServer_A08(int port) {
        this.port = port;
    }

    public synchronized void start() throws IOException {
        if (running) return;
        ServerSocket serverSocket = new ServerSocket(port);
        running = true;

        System.out.println("Secure Socket Server is starting...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;

        try {
            System.out.println("Secure Socket Server is stopping...");

            // Stop the server socket
            serverSocket.close();

            System.out.println("Secure Socket Server stopped!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_21648_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;

            try {
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Simulate integrity failure
                    if (message.equals("A08_IntegrityFailure")) {
                        out.writeUTF("Integrity Failure");
                        out.flush();

                        // Close the connection
                        clientSocket.close();
                        return;
                    }

                    out.writeUTF("Message received: " + message);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8189);
        server.start();
    }
}