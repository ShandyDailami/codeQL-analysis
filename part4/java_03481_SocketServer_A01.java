import java.io.*;
import java.net.*;
import java.util.*;

public class java_03481_SocketServer_A01 {
    private static ArrayList<Socket> clientSockets = new ArrayList<>();
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            clientSockets.add(socket);

            System.out.println("New client connected");

            // Start a new thread for handling the client
            new ClientHandler(socket).start();
        }
    }

    // Private class to handle each client
    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_03481_SocketServer_A01(Socket socket) {
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
                // Send a welcome message to the client
                out.println("Welcome to the server!");

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    // Send the same message back to the client
                    out.println(clientMessage);
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
    }
}