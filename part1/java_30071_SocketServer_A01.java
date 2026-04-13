import java.net.*;
import java.io.*;

public class java_30071_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(4444); // listening on port 4444
        System.out.println("Waiting for connection...");

        Socket socket = server.accept(); // accept client connection
        System.out.println("Connection established!");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String message = dis.readUTF(); // read message from client
        System.out.println("Received: " + message);

        String response = "Hello, client, your message was received!";
        dos.writeUTF(response); // send response to client
        System.out.println("Sent: " + response);

        socket.close();
    }
}