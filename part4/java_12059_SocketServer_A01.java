import java.net.ServerSocket;
import java.net.Socket;

public class java_12059_SocketServer_A01 {

    private static final int PORT = 12345; // Port to listen on

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT); // Create server socket
            System.out.println("Server is running and waiting for connections on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept(); // Accept a client connection
                System.out.println("Client connected from " + socket.getInetAddress().getHostAddress());

                // Handle the client connection in a new thread
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Class to handle individual client connections
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_12059_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Receive a message from the client
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);

                // Echo the message back to the client
                socket.getOutputStream().write(message.getBytes());

                socket.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}