import java.io.*;
import java.net.*;

public class java_11476_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientInput = dis.readUTF();
            System.out.println("Client says: " + clientInput);

            // Solution for Injection attacks
            String command = "Command: " + clientInput + " ";
            dos.writeUTF(command);
            dos.flush();

            System.out.println("Server says: " + command);
            socket.close();
        }
    }
}