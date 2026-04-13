import java.io.*;
import java.net.*;

public class java_25932_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received: " + request);

            String response = "Hello, client!";
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}