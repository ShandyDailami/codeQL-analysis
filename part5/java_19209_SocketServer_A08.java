import java.io.*;
import java.net.*;
import java.security.*;

public class java_19209_SocketServer_A08 {

    private static final String HASH_ALGORITHM = "SHA-256";
    private static final MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String data = dis.readUTF();
            System.out.println("Received data: " + data);

            digest.reset();
            digest.update(data.getBytes());
            byte[] bytes = digest.digest();

            String response = new String(bytes);
            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}