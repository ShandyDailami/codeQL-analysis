import java.io.*;
import java.net.*;
import java.util.*;

public class java_34207_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "Authenticated user: ";
    private static HashMap<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        userDatabase.put("admin", "password");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started. Listening on port 4444");
            while (true) {
                Socket socket = serverSocket.accept();
                handleClient(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            String clientMessage = in.readUTF();
            String username = clientMessage.split(":")[1];
            String password = clientMessage.split(":")[2];
            if (authenticateUser(username, password)) {
                out.writeUTF(AUTHENTICATED_USER + username);
            } else {
                out.writeUTF("Access denied for " + username);
            }
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean authenticateUser(String username, String password) {
        return userDatabase.get(username).equals(password);
    }
}