import java.io.*;
import java.net.*;

public class java_35724_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is running...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected!");

            // Handling communication
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Server accepts a message from the client
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // Server responds with a message to the client
            message = "Hello, client!";
            out.writeUTF(message);
            out.flush();

            client.close();
        }
    }
}