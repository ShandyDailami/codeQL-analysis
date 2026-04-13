import java.io.*;
import java.net.*;

public class java_16027_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String message;

        // Receive the message from the client
        message = dis.readUTF();
        System.out.println("Received: " + message);

        // Echo the message back to the client
        dos.writeUTF("Echo: " + message);
        dos.flush();

        socket.close();
    }
}