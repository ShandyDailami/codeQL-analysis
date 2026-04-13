import java.io.*;
import java.net.*;

public class java_36738_SocketServer_A01 {

    private static final int PORT = 6789;
    private static final String NAME = "localhost";

    private static void handleClient(Socket client) throws IOException {
        // read from client
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String message = dis.readUTF();
        System.out.println("Received: " + message);

        // send to client
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String response = "Message received";
        dos.writeUTF(response);
        System.out.println("Sent: " + response);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            System.out.println("Waiting for a client ...");
            Socket client = server.accept();
            System.out.println("Connected to: " + client.getRemoteSocketAddress());
            handleClient(client);
       
        }
    }
}