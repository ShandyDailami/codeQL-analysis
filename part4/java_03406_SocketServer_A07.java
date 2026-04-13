import java.io.*;
import java.net.*;
import java.util.*;

public class java_03406_SocketServer_A07 {
    private static final String AUTH_FAILURE_MESSAGE = "Authentication failure";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client accepted");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("authenticate")) {
                dos.writeUTF(AUTH_FAILURE_MESSAGE);
                System.out.println("Authenticated. Sending message: " + AUTH_FAILURE_MESSAGE);
            } else {
                dos.writeUTF("Invalid request");
                System.out.println("Invalid request received. Sending message: " + AUTH_FAILURE_MESSAGE);
            }

            dos.flush();
            client.close();
        }
    }
}