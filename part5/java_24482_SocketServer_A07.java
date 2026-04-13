import java.io.*;
import java.net.*;
import java.util.*;

public class java_24482_SocketServer_A07 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is running on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            clients.add(socket);
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        Socket socket;

        public java_24482_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Client says: " + clientMessage);
                    if (clientMessage.equalsIgnoreCase("exit")) {
                        clients.remove(socket);
                        socket.close();
                        System.out.println("Client disconnected: " + socket.getInetAddress().getHostAddress());
                    }

                    // Simulate authentication failure
                    if (clients.contains(socket)) {
                        writer.writeBytes("Authentication failed\n".getBytes());
                        writer.flush();
                        clients.remove(socket);
                        socket.close();
                        System.out.println("Client disconnected: " + socket.getInetAddress().getHostAddress());
                    } else {
                        writer.writeBytes("Authentication successful\n".getBytes());
                        writer.flush();
                    }
                }

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}