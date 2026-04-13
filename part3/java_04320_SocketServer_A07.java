import java.io.*;
import java.net.*;

public class java_04320_SocketServer_A07 {
    private static final String PASSWORD = "secret";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientPassword = dis.readUTF();

            if (clientPassword.equals(PASSWORD)) {
                dos.writeUTF("Authentication successful");
            } else {
                dos.writeUTF("Authentication failed");
           
            }
            socket.close();
        }
    }
}