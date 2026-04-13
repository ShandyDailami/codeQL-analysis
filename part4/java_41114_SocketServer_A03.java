import java.io.*;
import java.net.*;
import java.util.*;

public class java_41114_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello client, your message was: " + message;
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}