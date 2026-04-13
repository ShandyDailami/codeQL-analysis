import java.io.*;
import java.net.*;
import java.util.*;

public class java_29804_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_29804_SocketServer_A07(Socket socket) {
            this.socket = socket;
            setup();
        }

        private void setup() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                // Read the username and password from the client
                String request = reader.readLine();
                String[] credentials = request.split(" ");
                String providedUsername = credentials[0];
                String providedPassword = credentials[1];

                // Authenticate
                if (providedUsername.equals(USERNAME) && providedPassword.equals(PASSWORD)) {
                    writer.println("Authentication successful.");
                } else {
                    writer.println("Authentication failed.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String response;
            while (true) {
                try {
                    if ((response = reader.readLine()) != null) {
                        System.out.println("Received: " + response);
                    } else {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}