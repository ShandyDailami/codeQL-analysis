import java.io.*;
import java.net.*;

public class java_22453_SocketServer_A08 {
    private static boolean integrityCheckEnabled = true;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server is listening on port 8189");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // Start a new thread for the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_22453_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dis = new DataInputStream(input);

                // Read the client's name
                String clientName = dis.readUTF();
                System.out.println("Client name: " + clientName);

                // Check the integrity of the client's request
                if (integrityCheckEnabled) {
                    checkIntegrity(dis);
                }

                OutputStream output = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);

                // Send a response back to the client
                dos.writeUTF("Hello, " + clientName);
                dos.flush();

            } catch (IOException e) {
                System.out.println("Error processing client request");
                e.printStackTrace();
            }
        }

        private void checkIntegrity(DataInputStream dis) {
            try {
                // Read the client's integrity check
                String serverCheck = dis.readUTF();
                System.out.println("Server check: " + serverCheck);

                // Compare the client's check with the expected check
                if (!"expected-check".equals(serverCheck)) {
                    throw new SecurityException("Integrity check failure");
                }
            } catch (IOException e) {
                System.out.println("Error reading integrity check");
                e.printStackTrace();
            } catch (SecurityException e) {
                System.out.println("Security exception: " + e.getMessage());
                try {
                    // Send an error response back to the client
                    OutputStream output = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(output);
                    dos.writeUTF("Error: " + e.getMessage());
                    dos.flush();
                } catch (IOException ex) {
                    System.out.println("Error sending error response");
                    ex.printStackTrace();
                }
            }
        }
    }
}