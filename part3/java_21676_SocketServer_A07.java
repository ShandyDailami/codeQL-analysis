import java.io.*;
import java.net.*;
import java.util.*;

public class java_21676_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client...");
        Socket client = server.accept();
        System.out.println("Client connected");

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        String username = in.readUTF();
        String password = in.readUTF();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            out.writeUTF("Connection successful");
        } else {
            out.writeUTF("Authentication failed");
        }

        client.close();
    }
}