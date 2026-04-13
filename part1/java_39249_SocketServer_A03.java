import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39249_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Accepted new connection from " + client.getRemoteSocketAddress());

                new HandleClient(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HandleClient extends Thread {
        private final Socket socket;

        public java_39249_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can use your own logic for handling the client
                // For example, you can read a message from the client and perform some operations based on the message
                // For security-sensitive operations, avoid directly reading the stream. Instead, use a SecureInputStream or SecureReader
                socket.getInputStream().read();
                // socket.getInputStream().read(bytes);
                // socket.getInputStream().read(bytes, offset, length);

                // For instance, you can send a message to the client
                socket.getOutputStream().write("Hello, client!".getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}