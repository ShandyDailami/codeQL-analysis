import java.io.*;
import java.net.*;
import java.util.*;

public class java_10652_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(4444);
            System.out.println("Server started at port 4444");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected at port: " + client.getPort());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String clientUsername = in.readUTF();
                String clientPassword = in.readUTF();

                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    out.writeUTF("Authentication successful");
                } else {
                    out.writeUTF("Authentication failed");
                }

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}