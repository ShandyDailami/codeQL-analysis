import java.io.*;
import java.net.*;
import java.util.*;

public class java_32926_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server listening on port 12345");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            DataInputStream input = new DataInputStream(client.getInputStream());

            String message = "Server: Hello, client!";
            output.writeUTF(message);
            System.out.println("Server: " + message);

            String reply = input.readUTF();
            System.out.println("Client: " + reply);

            client.close();
        }
    }
}