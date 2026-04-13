import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class java_31063_SocketServer_A07 {
    private static final String PASSWORD = "securepassword";
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for a client ...");

        Socket socket = server.accept();
        System.out.println("Client accepted");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String clientMessage = in.readUTF();
        System.out.println("Received: " + clientMessage);

        String user = clientMessage.split(":")[0];
        String password = clientMessage.split(":")[1];

        if(isValidUser(user, password)) {
            out.writeUTF("Authentication successful!");
        } else {
            out.writeUTF("Authentication failed!");
        }

        out.close();
        socket.close();
        server.close();
    }

    private static boolean isValidUser(String user, String password) {
        return userDatabase.containsKey(user) && userDatabase.get(user).equals(password);
    }
}