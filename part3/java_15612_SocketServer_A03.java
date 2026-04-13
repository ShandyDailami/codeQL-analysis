import java.net.*;
import java.io.*;

public class java_15612_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client on port: " + 6000);
        Socket client = server.accept();
        System.out.println("Connected to client");

        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        String message;
        while ((message = dis.readUTF()) != null) {
            System.out.println("Client says: " + message);
            dos.writeUTF("Server says: " + message);
            dos.flush();
        }

        client.close();
        server.close();
    }
}