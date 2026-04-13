import java.io.*;
import java.net.*;

public class java_13232_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message received from client: " + message);

            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Message sent to client: " + response);

            socket.close();
        }
    }
}