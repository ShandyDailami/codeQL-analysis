import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class java_11016_SocketServer_A07 {
    private static HashMap<String, String> users = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {
        // Adding users to the system for testing
        users.put("alice", "alice");
        users.put("bob", "bob");

        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Handling client connection in a new thread
            new HandleClient(socket).start();
        }
    }

    private static class HandleClient extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_11016_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        public void run() {
            try {
                // Read username and password from client
                String username = in.readLine();
                String password = in.readLine();

                // Authenticate user
                if (users.get(username).equals(password)) {
                    out.println("Welcome " + username);
                } else {
                    out.println("Authentication failed");
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}