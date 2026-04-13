import java.net.*;
import java.io.*;
import java.security.*;

public class java_38309_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Generate a RSA key pair
            KeyPair keyPair = generateRSAKeyPair();

            // Send the RSA key pair to the client
            dos.writeUTF(keyPair.getPublic().getClass().getName());
            dos.writeObject(keyPair.getPublic());
            dos.writeUTF(keyPair.getPrivate().getClass().getName());
            dos.writeObject(keyPair.getPrivate());

            // Close the streams
            dos.close();
            dis.close();

            // Close the socket
            socket.close();
        }
    }

    // Method to generate RSA key pair
    public static KeyPair generateRSAKeyPair() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return keyPair;
    }
}