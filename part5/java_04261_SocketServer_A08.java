import java.io.*;
import java.net.*;
import java.util.*;

public class java_04261_SocketServer_A08 {
    private static ArrayList<Socket> clientSockets = new ArrayList<>();
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                clientSockets.add(socket);
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_04261_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Add your security-sensitive operations here
                    // For example, checking for integrity failures
                    // But it's not a classic example of a security vulnerability, it's a placeholder for you to fill in

                    // Write the message back to the client
                    out.println("Server received: " + message);
                }
                socket.close();
                clientSockets.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}