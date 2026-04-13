import java.io.*;
import java.net.*;

public class java_14622_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started. Listening for connections on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected.");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();

            System.out.println("Received message: " + message);

            String response = "Hello, client!";

            dataOutputStream.writeUTF(response);

            socket.close();
       
            System.out.println("Connection closed.");
        }
    }
}