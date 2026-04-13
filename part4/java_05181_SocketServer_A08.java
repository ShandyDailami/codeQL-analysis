import java.io.*;
import java.net.*;
import java.util.*;

public class java_05181_SocketServer_A08 {

    private static List<Socket> clients = new ArrayList<>();
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(9999);
            System.out.println("Server started on port 9999");
            while (true) {
                Socket socket = server.accept();
                clients.add(socket);
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_05181_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);
                    // TODO: Implement security-sensitive operations related to A08_IntegrityFailure
                    // For now, just echo the message back to the client
                    out.writeUTF(message);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                clients.remove(socket);
            }
        }
    }
}