import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_32504_SocketServer_A07 {
    private static HashMap<String, String> users = new HashMap<String, String>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(80);
            System.out.println("Server is listening on port 80...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Authentication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientInput = in.readUTF();
                String[] clientInfo = clientInput.split(" ");

                if ("login".equals(clientInfo[0]) && clientInfo.length == 3) {
                    if (authenticate(clientInfo[1], clientInfo[2])) {
                        out.writeUTF("Authentication successful");
                    } else {
                        out.writeUTF("Authentication failed");
                    }
                } else {
                    out.writeUTF("Unknown command");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        // This method just for demonstration purposes. It should be replaced by a more secure method of authentication.
        return "admin".equals(username) && "password".equals(password);
    }
}