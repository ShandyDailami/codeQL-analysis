import java.io.*;
import java.net.*;
import java.util.*;

public class java_10181_SocketServer_A07 {

    private List<String> authorizedUsers = new ArrayList<>();
    private String serverPassword = "securePassword";

    public java_10181_SocketServer_A07() {
        authorizedUsers.add("user1");
        authorizedUsers.add("user2");
        authorizedUsers.add("user3");
    }

    public void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_10181_SocketServer_A07(Socket socket) {
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
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    String[] messageParts = clientMessage.split(" ");
                    if (messageParts.length != 2 || !messageParts[0].equals("auth")) {
                        out.println("Invalid message");
                        out.flush();
                        continue;
                    }
                    String user = messageParts[1];
                    if (isAuthorized(user)) {
                        out.println("Access granted");
                    } else {
                        out.println("Access denied");
                    }
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isAuthorized(String user) {
            return authorizedUsers.contains(user) && user.equals(getPassword(user));
        }

        private String getPassword(String user) {
            return user.equals("user1") ? serverPassword : user;
        }
    }

    public static void main(String[] args) {
        new SecureServer().startServer(1234);
    }
}