import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12300_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                new HandleClient(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }

    private static class HandleClient extends Thread {
        private Socket socket;

        public java_12300_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // TODO: Implement a secure authentication mechanism here
                // For simplicity, we're checking for a username and password.
                // In a real-world scenario, you'd use a more secure method of authentication.
                String clientUsername = socket.getInputStream().readUTF();
                String clientPassword = socket.getInputStream().readUTF();

                if (!clientUsername.equals(USERNAME) || !clientPassword.equals(PASSWORD)) {
                    socket.getOutputStream().writeUTF("A07_AuthFailure");
                    return;
                }

                socket.getOutputStream().writeUTF("A07_AuthSuccess");
            } catch (IOException ex) {
                System.out.println("Error handling client connection: " + ex.getMessage());
            }
        }
    }
}