import java.io.*;
import java.net.*;
import java.util.*;

public class java_33525_SocketServer_A08 {

    private static Map<Socket, User> connections = new HashMap<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started on port 4444");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                User user = new User(socket);
                connections.put(socket, user);
                user.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class User extends Thread {
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_33525_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);
                    if (!connections.containsValue(this)) {
                        out.writeUTF("Connection closed by user");
                        connections.remove(socket);
                        socket.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}