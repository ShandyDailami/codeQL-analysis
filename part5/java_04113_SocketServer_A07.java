import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_04113_SocketServer_A07 {
    private static final String DEFAULT_AUTH_REALM = "Example Realm";
    private static final Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("user1", "user1");
        USERS.put("user2", "user2");
        // Add more users as needed...
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080, 1024, InetAddress.getByName("127.0.0.1"));
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_04113_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.setSoTimeout(10000);
                socket.setReuseAddress(true);

                Authenticator authenticator = new Authenticator() {
                    @Override
                    protected javax.security.auth.Subject getSubject(String challenge) throws IOException, javax.security.auth.InvalidLoginException {
                        String id = challenge.substring("Basic".length());
                        String password = USERS.get(id);

                        if (password == null || !password.equals("password")) {
                            throw new IOException("Invalid username or password");
                        }

                        return new CallbackHandler().getSubject(challenge);
                    }
                };

                socket.authenticate(authenticator);
            } catch (IOException e) {
                System.out.println("Authentication failed: " + e.getMessage());
            }
        }
    }
}