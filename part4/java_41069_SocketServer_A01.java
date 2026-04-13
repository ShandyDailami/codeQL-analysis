import java.io.*;
import java.net.*;

public class java_41069_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Reading request from client
            String request = in.readUTF();
            System.out.println("Request received: " + request);

            // Sending response to client
            String response = "Hello, client!";
            out.writeUTF(response);
            out.flush();
            System.out.println("Response sent: " + response);

            client.close();
        }
    }
}