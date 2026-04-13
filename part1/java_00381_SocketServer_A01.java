import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_00381_SocketServer_A01 {
    private HashMap<String, String> users = new HashMap<String, String>();
    private String[] validPasswords = {"password1", "password2", "password3"};

    public java_00381_SocketServer_A01() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public void start(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String user = input.readUTF();
            String password = input.readUTF();

            if (isValid(user, password)) {
                System.out.println("Authentication successful for user: " + user);
                output.writeUTF("Authentication successful");
            } else {
                System.out.println("Authentication failed for user: " + user);
                output.writeUTF("Authentication failed");
            }

            output.close();
            socket.close();
        }
    }

    private boolean isValid(String user, String password) {
        return Arrays.asList(validPasswords).contains(password);
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start(1234);
    }
}