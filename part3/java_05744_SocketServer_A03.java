import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05744_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_05744_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // In this example, we assume that the client sends a simple string and the server replies with the same string
                // This is a very basic example of a client-server protocol, and a real-world application would likely be more complex
                String message = socket.getInputStream().readUTF();
                System.out.println("Received message from client: " + message);

                String response = message;
                socket.getOutputStream().writeUTF(response);
                socket.getOutputStream().flush();
            } catch (IOException e) {
                System.err.println("Failed to handle client connection from " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            }
        }
    }
}