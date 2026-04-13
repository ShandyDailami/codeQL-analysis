import java.io.*;
import java.net.*;
import java.util.*;

public class java_07371_SocketServer_A08 {
    private static final int PORT = 8080;
    private static boolean shutdown = false;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (!shutdown) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // create a new thread for each client
            new ClientHandler(socket).start();
        }

        serverSocket.close();
    }

    static class ClientHandler extends Thread {
        private final Socket socket;

        public java_07371_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                DataInputStream dis = new DataInputStream(in);
                DataOutputStream dos = new DataOutputStream(out);

                String request = dis.readUTF();
                System.out.println("Received: " + request);

                if (request.equalsIgnoreCase("shutdown")) {
                    shutdown = true;
                    dos.writeUTF("shutdown acknowledged");
                    System.out.println("Shutdown command received, server is shutting down");
                } else {
                    dos.writeUTF("Error: Invalid request");
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }
    }
}