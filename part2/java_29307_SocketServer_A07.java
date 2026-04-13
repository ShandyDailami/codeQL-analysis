import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29307_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed";

    private String[] validUsers = {"user1", "user2", "user3"};
    private String[] validPasswords = {"password1", "password2", "password3"};

    public void startServer(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = server.accept();
                new AuthenticationThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting connection: " + e.getMessage());
        }
    }

    private class AuthenticationThread extends Thread {
        private Socket socket;
        private String username;
        private String password;

        public java_29307_SocketServer_A07(Socket socket) {
            this.socket = socket;
            start();
        }

        @Override
        public void run() {
            try {
                socket.receive(); // Receive the username and password
                this.username = socket.getInputStream().readUTF();
                this.password = socket.getInputStream().readUTF();

                if (isAuthenticated()) {
                    socket.getOutputStream().writeUTF(AUTHENTICATION_SUCCESS);
                    socket.getOutputStream().flush();
                } else {
                    socket.getOutputStream().writeUTF(AUTHENTICATION_FAILURE);
                    socket.getOutputStream().flush();
                }
            } catch (IOException e) {
                System.out.println("Error in authentication: " + e.getMessage());
            }
        }

        private boolean isAuthenticated() {
            for (int i = 0; i < validUsers.length; i++) {
                if (validUsers[i].equals(username) && validPasswords[i].equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer().startServer(1234);
    }
}