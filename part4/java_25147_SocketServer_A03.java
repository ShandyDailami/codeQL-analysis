import java.io.*;
import java.net.*;

public class java_25147_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666); // port number
        System.out.println("Server is running and waiting for client connection...");

        Socket client = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        String message = in.readUTF();
        System.out.println("Received message from client: " + message);

        String response = "Hello, client!";
        out.writeUTF(response);

        client.close();
        server.close();
   
    }
}