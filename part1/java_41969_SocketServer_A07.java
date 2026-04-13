import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41969_SocketServer_A07 {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String AUTH_USERNAME = "user";
    private static final String AUTH_PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                AuthenticationHandler authenticationHandler = new AuthenticationHandler(socket);
                authenticationHandler.handleAuthentication();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class AuthenticationHandler {
        private final Socket socket;
        private String username;
        private String password;

        public java_41969_SocketServer_A07(Socket socket) {
            this.socket = socket;
            this.username = AUTH_USERNAME;
            this.password = AUTH_PASSWORD;
        }

        public void handleAuthentication() {
            try {
                socket.getInputStream().readUTF(); // read length of the username
                username = socket.getInputStream().readUTF(); // read username
                password = socket.getInputStream().readUTF(); // read password

                if (authenticate()) {
                    socket.getOutputStream().writeUTF("OK");
                } else {
                    socket.getOutputStream().writeUTF("FAIL");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate() {
            // Here we should use a secure method to compare the username and password with the stored ones,
            // but for simplicity, we are just checking if they match.
            return username.equals(AUTH_USERNAME) && password.equals(AUTH_PASSWORD);
        }
    }
}