import java.io.*;
import java.net.*;

public class java_24547_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while(true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Welcome to the server! Connection successful.");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            System.out.println(inputStream.readUTF());

            socket.close();
       
        }
    }
}