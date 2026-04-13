import java.io.*;
import java.net.*;

public class java_42124_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server is listening on port 9999...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            String response = "Hello, Client!";
            outputStream.writeUTF(response);

            socket.close();
        }
    }
}