import java.io.*;
import java.net.*;

public class java_14747_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8001);
        System.out.println("Server is listening on port 8001");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            String response = "Hello, client!";
            output.writeUTF(response);

            socket.close();
        }
    }
}