import java.io.*;
import java.net.*;
import java.util.*;

public class java_36962_SocketServer_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    private static String decrypt(String encrypted) {
        // Here we'll just return the encrypted string as it is.
        // In a real scenario, you would decrypt the encrypted string.
        return encrypted;
    }

    public static boolean authenticate(String clientUsername, String clientPassword) {
        return USERNAME.equals(clientUsername) && PASSWORD.equals(clientPassword);
    }

    public static void handleClient(Socket client) throws IOException {
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        String clientUsername = dis.readUTF();
        String clientPassword = decrypt(dis.readUTF());

        boolean isAuthenticated = authenticate(clientUsername, clientPassword);

        dos.writeUTF(isAuthenticated ? "Welcome" : "Access denied");
        dos.flush();

        client.close();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);

        System.out.println("Server is listening on port 1234...");

        while (true) {
            Socket client = server.accept();

            System.out.println("Client connected!");

            new Thread(() -> {
                try {
                    handleClient(client);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}