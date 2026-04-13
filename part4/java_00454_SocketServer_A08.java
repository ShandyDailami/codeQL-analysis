import java.io.*;
import java.net.*;
import java.util.*;

public class java_00454_SocketServer_A08 {

    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                clients.add(socket);

                Thread clientThread = new Thread(new ClientHandler(socket));
                clientThread.start();
            } catch (IOException e) {
                System.out.println("Client connection failed: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public java_00454_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Check if it's a message to stop the server
                    if (message.equals("STOP")) {
                        socket.close();
                        clients.remove(socket);
                        System.out.println("Server stopped");
                        return;
                    }

                    // Send a response back to the client
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println("Server received your message: " + message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected: " + e.getMessage());
                clients.remove(socket);
            }
        }
    }
}