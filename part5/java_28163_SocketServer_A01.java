import java.io.*;
import java.net.*;

public class java_28163_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8181);
        System.out.println("Server is listening on port 8181...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected...");

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // Security-sensitive operation: Broken Access Control
            // Do not allow anyone to access the server except this user
            String user = in.readUTF();
            if (!"username".equals(user)) {
                out.writeUTF("Access Denied");
                out.flush();
                continue;
            }

            // Secure operation: Encrypting the message
            String encryptedMessage = encrypt(message);
            out.writeUTF(encryptedMessage);
            out.flush();
       
            client.close();
        }
    }

    private static String encrypt(String message) {
        // Implementation of encryption algorithm goes here
        // This is a dummy operation
        return message;
    }
}