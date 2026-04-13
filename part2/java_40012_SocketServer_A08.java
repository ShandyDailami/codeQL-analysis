import java.io.*;
import java.net.*;

public class java_40012_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Simulate data exchange
            outputStream.writeUTF("Hello, client!");

            // Simulate integrity failure by closing the output stream
            outputStream.close();

            socket.close();
        }
    }
}