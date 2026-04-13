import java.io.*;
import java.net.*;

public class java_09019_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started on port 6000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // This is a placeholder for a security-sensitive operation
            // It can be any operation that requires high level security
            String response = "Server response: " + request;

            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}