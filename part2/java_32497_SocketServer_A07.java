import java.io.*;
import java.net.*;
import java.util.*;

public class java_32497_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "AuthenticatedUser";
    private static List<String> authorizedUsers = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_32497_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String clientMessage = in.readUTF();
                System.out.println("Received: " + clientMessage);
                if (authenticate(clientMessage)) {
                    out.writeUTF(AUTHENTICATED_USER);
                } else {
                    out.writeUTF("Unauthorized user");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String user) {
            return authorizedUsers.contains(user);
        }
    }
}