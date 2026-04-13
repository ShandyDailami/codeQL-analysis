import java.io.*;
import java.net.*;
import java.util.*;

public class java_36120_SocketServer_A07 {
    private static final String AUTH_SERVER_NAME = "Auth Server";
    private static final int PORT = 8888;

    private static List<String> authenticatedUsers = Collections.synchronizedList(new ArrayList<String>());
    private static Map<String, String> credentials = new HashMap<String, String>() {
        {
            put("user1", "password1");
            put("user2", "password2");
        }
    };

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client connected: " + socket.getRemoteSocketAddress());
                new AuthThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class AuthThread extends Thread {
        private Socket socket;

        public java_36120_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String clientMsg, serverMsg;
                while ((clientMsg = reader.readLine()) != null) {
                    System.out.println("Client: " + clientMsg);
                    String user = clientMsg.split(" ")[0];
                    String password = clientMsg.split(" ")[1];
                    if (authenticateUser(user, password)) {
                        writer.println("Successfully authenticated");
                    } else {
                        writer.println("Authentication failed");
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticateUser(String user, String password) {
            if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
                authenticatedUsers.add(user);
                return true;
            }
            return false;
        }
    }
}