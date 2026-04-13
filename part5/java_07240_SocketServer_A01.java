import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07240_SocketServer_A01 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Use a custom Authentication mechanism for the connection
                // In a real application, you would want to validate the client's credentials in the server
                if (authenticate(socket)) {
                    new ClientHandler(socket).start();
                } else {
                    System.out.println("Access Denied for: " + socket.getRemoteSocketAddress());
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Custom Authentication mechanism
    private static boolean authenticate(Socket socket) {
        // Replace this with your own authentication mechanism
        return true;
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_07240_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle the client's request here
        }
    }
}