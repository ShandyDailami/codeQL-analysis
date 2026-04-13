import java.io.*;
import java.net.*;

public class java_32326_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message from client: " + message);

            String response = "Hello, client!";
            dataOutputStream.writeUTF(response);
            System.out.println("Sent message to client: " + response);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}