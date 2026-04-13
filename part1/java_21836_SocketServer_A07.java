import java.io.*;
import java.net.*;
import java.util.*;

public class java_21836_SocketServer_A07 {
    private static List<String> validUsers = Arrays.asList("user1", "user2", "user3");

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            Socket socket = server.accept();
            new AuthServerThread(socket).start();
        }
    }

    private static class AuthServerThread extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_21836_SocketServer_A07(Socket socket) {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                String user = reader.readLine();
                if (user != null && validUsers.contains(user)) {
                    writer.println("Authentication successful");
                } else {
                    writer.println("Authentication failed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}