import java.io.*;
import java.net.*;

public class java_01355_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String message = inputStream.readUTF();
            System.out.println("Received: " + message);

            outputStream.writeUTF("Message received");
            outputStream.flush();

            socket.close();
       
        }
    }
}