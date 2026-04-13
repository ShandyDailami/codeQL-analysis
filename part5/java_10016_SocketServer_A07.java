import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10016_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            // Create a server socket at port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started");

            while (true) {
                // Wait for a client to connect
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Perform authentication
                if (authenticate(socket)) {
                    // Create a new thread for the client
                    new ClientThread(socket).start();
                } else {
                    System.out.println("Authentication failed, closing connection");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Simulate authentication by checking if the address is localhost
        return socket.getInetAddress().getHostAddress().equals("127.0.0.1");
    }

    private static class ClientThread extends Thread {
        private Socket socket;

        public java_10016_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }
}