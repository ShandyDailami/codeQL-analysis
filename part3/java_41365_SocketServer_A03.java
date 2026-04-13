import java.net.*;
import java.io.*;

public class java_41365_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4445);
        System.out.println("Server started on port 4445");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client, your message was: " + message;
            out.writeUTF(response);

            socket.close();
        }
    }
}