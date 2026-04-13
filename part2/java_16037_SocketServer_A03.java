import java.io.*;
import java.net.*;

public class java_16037_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server started on port 6666");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // read and print incoming message
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // send back a simple response
            output.writeUTF("Server received your message");

            socket.close();
        }
    }
}