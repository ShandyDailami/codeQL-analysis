import java.io.*;
import java.net.*;

public class java_24761_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String response = "Hello, Client!";
            out.writeUTF(response);

            socket.close();
        }
    }
}