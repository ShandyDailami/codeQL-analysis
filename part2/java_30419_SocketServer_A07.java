import java.io.*;
import java.net.*;
import java.util.*;

public class java_30419_SocketServer_A07 {

    private static final String USER_FILE = "users.txt";
    private static HashMap<String, String> users = new HashMap<>();

    static {
        // Load users from file
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                users.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_30419_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    if (authenticate(request)) {
                        out.println("Welcome!");
                    } else {
                        out.println("Authentication failed");
                    }
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String request) {
            String[] parts = request.split(" ");
            if (users.containsKey(parts[1]) && users.get(parts[1]).equals(parts[2])) {
                return true;
            }
            return false;
        }
    }
}