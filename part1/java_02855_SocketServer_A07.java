import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02855_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server started...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted: " + socket.getRemoteSocketAddress());

                Authenticator authenticator = new Authenticator() {
                    @Override
                    public boolean authenticate(String userName) {
                        return USERNAME.equals(userName);
                    }

                    @Override
                    public String getPassword() {
                        return PASSWORD;
                    }
                };

                if (!socket.setAuthenticator(authenticator)) {
                    System.out.println("Authentication failed.");
                    socket.close();
                    continue;
                }

                // Process incoming data
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;

        public java_02855_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle incoming data
        }
    }
}