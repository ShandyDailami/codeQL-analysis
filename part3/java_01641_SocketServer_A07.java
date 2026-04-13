import java.io.*;
import java.net.*;
import java.util.*;

public class java_01641_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the authentication request
            String request = in.readUTF();
            String[] auth = request.split(" ");

            // Verify the authentication request
            if (auth.length == 2 && auth[0].equals("AUTH") && auth[1].equals(USERNAME + ":" + PASSWORD)) {
                out.writeUTF("OK");
            } else {
                out.writeUTF("ERROR");
            }

            out.close();
            socket.close();
        }
    }
}