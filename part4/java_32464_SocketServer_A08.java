import java.io.*;
import java.net.*;

public class java_32464_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String clientMessage;

        // Receive message from client
        clientMessage = dis.readUTF();
        System.out.println("Received: " + clientMessage);

        // Sending the same message back to client
        dos.writeUTF(clientMessage);
        dos.flush();

        // Close connection
        socket.close();
    }
}