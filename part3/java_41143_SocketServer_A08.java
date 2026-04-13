import java.io.*;
import java.net.*;
import java.util.*;

public class java_41143_SocketServer_A08 {
    private static final int PORT = 9876;
    private static Set<Socket> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for connections on port: " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());
                clients.add(socket);
                HandleClient clientHandler = new HandleClient(socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClient extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_41143_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    String response = processMessage(message);
                    out.println(response);
                    out.flush();
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                clients.remove(socket);
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processMessage(String message) {
            // Process message here (for instance, encrypt it, add integrity failure, etc.)
            // Add your security-sensitive operations here.
            // For example:
            // return "Message processed: " + message;
            return "Message processed: " + message;
        }
    }
}