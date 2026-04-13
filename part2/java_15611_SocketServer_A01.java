import java.io.*;
import java.net.*;

public class java_15611_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);

        System.out.println("Waiting for a client to connect...");

        Socket socket = server.accept();

        System.out.println("Client connected");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message = in.readUTF();

        System.out.println("Message received: " + message);

        out.writeUTF("Message received: " + message);

        out.close();
        in.close();

        socket.close();
        server.close();
    }
}