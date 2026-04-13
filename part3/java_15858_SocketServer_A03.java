import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15858_SocketServer_A03 {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Server started on port 1234");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create new thread for each client connection
                new Handler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends Thread {
        private Socket client;

        public java_15858_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (Socket socket = client) {
                while (true) {
                    // Read message from client
                    String message = socket.getInputStream().readUTF();
                    System.out.println("Received: " + message);

                    // Broadcast message to all clients
                    for (Socket sock : ServerSocketInstance.sockets.values()) {
                        sock.getOutputStream().writeUTF(message);
                    }
                }
            } catch (IOException e) {
                ServerSocketInstance.sockets.remove(client);
                System.out.println("Client disconnected from " + client.getRemoteSocketAddress());
            }
        }
    }

    static class ServerSocketInstance {
        public static java.util.Map<Socket, Socket> sockets = new java.util.HashMap<>();
    }
}