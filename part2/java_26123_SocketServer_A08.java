import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_26123_SocketServer_A08 {
    private static HashMap<String, String> credentials = new HashMap<>();

    static {
        // Add your credentials here
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readLine();
            String[] parts = clientMessage.split(" ");
            String username = parts[0];
            String password = parts[1];

            if (authenticate(username, password)) {
                out.write("Authentication successful.\n".getBytes());
            } else {
                out.write("Authentication failed.\n".getBytes());
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return credentials.get(username).equals(password);
    }
}