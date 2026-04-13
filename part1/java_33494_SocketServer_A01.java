import java.net.*;
import java.io.*;
import java.util.*;

public class java_33494_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9000);
        System.out.println("Server is listening on port 9000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Message from client: " + message);

            String response = "Hello, client, thanks for connecting!";
            dos.writeUTF(response);
            System.out.println("Server's response: " + response);

            dos.close();
            socket.close();
        }
    }
}