import java.io.*;
import java.net.*;

public class java_21664_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080.");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Read the username and password from the socket
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String username = in.readUTF();
                String password = in.readUTF();

                // Authenticate the user
                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    System.out.println("Authentication successful.");
                } else {
                    System.out.println("Authentication failed.");
                    socket.close();
                    continue;
                }

                // Handle client requests in a new thread
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_21664_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello, client!");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}