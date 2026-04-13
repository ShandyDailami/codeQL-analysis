import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_14722_SocketServer_A07 {

    private static HashMap<String, String> userDB = new HashMap<>();

    static {
        userDB.put("user1", "password1");
        userDB.put("user2", "password2");
        userDB.put("user3", "password3");
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port: " + 12345);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String clientMsg = inputStream.readUTF();
                String[] parts = clientMsg.split(":");
                if ("login".equals(parts[0]) && authenticate(parts[1], parts[2])) {
                    outputStream.writeUTF("success");
                } else {
                    outputStream.writeUTF("failure");
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* Cannot do anything - IO is closed */ }
            }
        }
    }

    private static boolean authenticate(String username, String password) {
        return username != null && username.length() > 0 && password != null && username.length() > 0 
                && userDB.get(username).equals(password);
    }
}