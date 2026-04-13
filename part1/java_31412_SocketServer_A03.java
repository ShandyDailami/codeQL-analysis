import java.io.*;
import java.net.*;

public class java_31412_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);

            message = "Hello, client, you've connected successfully to the server";
            outputStream.writeUTF(message);
            outputStream.flush();

            socket.close();
        }
    }
}