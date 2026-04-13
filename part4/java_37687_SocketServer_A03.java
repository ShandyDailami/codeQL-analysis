import java.io.*;
import java.net.*;
import java.util.*;

// The server socket
public class java_37687_SocketServer_A03 {
    private static final int PORT = 4445;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            // Wrap the socket in a PrintWriter
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            clients.add(writer);

            // Start the thread to handle the client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    // The client handler
    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_37687_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Broadcast the message to all clients
                    for (PrintWriter writer : clients) {
                        writer.println(message);
                    }
                }

                // Remove the writer from the set
                clients.remove(socket.getOutputStream());
                System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}