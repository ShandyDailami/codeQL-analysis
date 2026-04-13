import java.io.*;
import java.net.*;

public class java_12768_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create streams for reading and writing
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Handle client communication in a separate thread
                Thread thread = new Thread(new ClientHandler(dataInputStream, dataOutputStream));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ClientHandler implements Runnable {
        private DataInputStream dataInputStream;
        private DataOutputStream dataOutputStream;

        public java_12768_SocketServer_A01(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
            this.dataInputStream = dataInputStream;
            this.dataOutputStream = dataOutputStream;
        }

        @Override
        public void run() {
            try {
                // Read message from client
                String message = dataInputStream.readUTF();
                System.out.println("Received message: " + message);

                // Broadcast message to all clients
                for (Socket socket : ServerApp.clients.values()) {
                    dataOutputStream.writeUTF(message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}