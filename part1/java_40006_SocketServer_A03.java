import java.io.*;
import java.net.*;
import java.util.*;

public class java_40006_SocketServer_A03 {

    private static final String SERVER_NAME = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String QUIT_COMMAND = "quit";

    private static Set<String> authorizedUsers = new HashSet<>();

    static {
        authorizedUsers.add("user1");
        authorizedUsers.add("user2");
        authorizedUsers.add("user3");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started at " + SERVER_NAME + ":" + SERVER_PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            new HandleClient(clientSocket).start();
        }
    }

    private static class HandleClient extends Thread {

        private final Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_40006_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    handleClientRequest(clientMessage);
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void handleClientRequest(String clientMessage) {
            if (clientMessage.toLowerCase().equals(QUIT_COMMAND)) {
                out.println("You have quit the chat");
                return;
            }

            if (isUserAuthorized(clientMessage)) {
                out.println("Welcome " + clientMessage);
            } else {
                out.println("Access denied");
            }

            out.flush();
        }

        private boolean isUserAuthorized(String username) {
            return authorizedUsers.contains(username);
        }
    }
}