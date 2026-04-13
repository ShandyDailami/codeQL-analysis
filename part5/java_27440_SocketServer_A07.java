import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27440_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        authenticate();
    }

    private static void authenticate() {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket socket = server.accept();
                new AuthenticationThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class AuthenticationThread extends Thread {
        private final Socket socket;

        public java_27440_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                java.io.DataInputStream in = new java.io.DataInputStream(socket.getInputStream());
                java.io.DataOutputStream out = new java.io.DataOutputStream(socket.getOutputStream());

                // Read username and password from client
                String username = in.readUTF();
                String password = in.readUTF();

                // Authenticate
                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    out.writeUTF("Authentication successful!");
                    out.flush();
                } else {
                    out.writeUTF("Authentication failed!");
                    out.flush();
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}