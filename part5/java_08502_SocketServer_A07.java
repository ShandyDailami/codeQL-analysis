import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08502_SocketServer_A07 {

    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_08502_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read username from client
                java.io.ObjectInputStream in = new java.io.ObjectInputStream(socket.getInputStream());
                String username = in.readUTF();

                // Perform authentication
                if (authenticateUser(username)) {
                    // Send authentication success message
                    java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(socket.getOutputStream());
                    out.writeUTF(AUTHENTICATION_SUCCESS);
                } else {
                    // Send authentication failure message
                    java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(socket.getOutputStream());
                    out.writeUTF(AUTHENTICATION_FAILURE);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticateUser(String username) {
            // Implement authentication logic here.
            // This is just a placeholder for demonstration purposes.
            return true;
        }
    }
}