import java.io.*;
import java.net.*;

public class java_07050_SocketServer_A03 {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            message = "Hello client, you've connected to the secure server!";
            dos.writeUTF(message);
            System.out.println("Server says: " + message);

            socket.close();
        }
    }
}