import java.io.*;
import java.net.*;

public class java_09795_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Message from client: " + message);

            String response = "Hello, client!";
            output.writeUTF(response);
            System.out.println("Response sent to client");

            socket.close();
        }
    }
}