import java.io.*;
import java.net.*;

public class java_04384_SocketServer_A07 {

    private static final String PASSWORD = "secure";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String clientMsg = dis.readUTF();
        System.out.println("Received: " + clientMsg);

        if (authenticate(clientMsg)) {
            dos.writeUTF("Connection successful");
        } else {
            dos.writeUTF("Authentication failed");
        }

        dos.close();
        socket.close();
        server.close();
    }

    private static boolean authenticate(String clientMsg) {
        String[] pairs = clientMsg.split(":");
        String username = pairs[0];
        String password = pairs[1];

        return PASSWORD.equals(password);
    }
}