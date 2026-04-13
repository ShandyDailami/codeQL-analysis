import java.io.*;
import java.net.*;

public class java_33216_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            String response = "Hello, client, your message was: " + message;
            dataOutputStream.writeUTF(response);
            System.out.println("Sent response: " + response);

            socket.close();
        }
    }
}