import java.io.*;
import java.net.*;
import java.util.*;

public class java_11638_SocketServer_A07 {
    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            server = new ServerSocket(4444);
            System.out.println("Server started on port: 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                clients.add(socket);

                // Handling the client in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_11638_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Simulate authentication failure
                    if (message.equals("auth failure")) {
                        out.println("Auth failure");
                        out.flush();
                        socket.close();
                        clients.remove(socket);
                    } else {
                        out.println("Successfully authenticated");
                        out.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}