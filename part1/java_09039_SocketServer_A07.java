import java.io.*;
import java.net.*;
import java.util.*;

public class java_09039_SocketServer_A07 {
    private static final String USERS_FILE = "users.txt";
    private static List<String> validUsers = new ArrayList<>();

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                validUsers.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started, waiting for clients...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted: " + socket.getInetAddress().getHostAddress());

                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_09039_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);

                    if (authenticate(request)) {
                        writer.println("Welcome, user!");
                    } else {
                        writer.println("Access denied.");
                    }

                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String request) {
            String[] parts = request.split(" ");
            if (parts.length != 2) {
                return false;
            }

            String user = parts[0];
            String password = parts[1];

            return isValidUser(user) && isValidPassword(user, password);
        }

        private boolean isValidUser(String user) {
            return validUsers.contains(user);
        }

        private boolean isValidPassword(String user, String password) {
            // For simplicity, just check if password is "password".
            // In a real application, you should check the password against a hash in the database.
            return password.equals("password");
        }
    }
}