import java.io.*;
import java.net.*;

public class java_04918_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for connection...");
        Socket sock = server.accept();
        System.out.println("Connection accepted");

        DataInputStream dis = new DataInputStream(sock.getInputStream());
        DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

        String message = dis.readUTF();
        System.out.println("Client says: " + message);

        String response = "Hello, client!";
        dos.writeUTF(response);

        sock.close();
    }
}