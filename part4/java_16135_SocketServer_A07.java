import java.io.*;
import java.net.*;

public class java_16135_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String clientMessage = in.readUTF();
        System.out.println("Client says: " + clientMessage);

        // Add authentication
        if (authenticate(clientMessage)) {
            out.writeUTF("Authentication successful");
        } else {
            out.writeUTF("Authentication failed");
        }

        socket.close();
    }

    private static boolean authenticate(String message) {
        // Replace this with your own authentication logic.
        return message.equals("test");
    }
}