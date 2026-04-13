import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15721_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("Server started. Listening for connections on port 12345.");

        while (true) {
            Socket socket = serverSocket.accept();

            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_15721_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // read username and password from the socket
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String username = reader.readLine();
                String password = reader.readLine();

                // check if username and password match
                if (username.equals(AUTHENTICATED_USER) && password.equals(AUTHENTICATED_PASSWORD)) {
                    System.out.println("Authenticated user " + username);
                    // send a welcome message back to the client
                    socket.getOutputStream().write("Welcome to the server\n".getBytes());
                } else {
                    System.out.println("Failed to authenticate user " + username);
                    // send an error message back to the client
                    socket.getOutputStream().write("Failed to authenticate\n".getBytes());
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}