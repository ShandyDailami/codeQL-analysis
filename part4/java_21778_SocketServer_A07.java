import java.io.*;
import java.net.*;

public class java_21778_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("Connection established");

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                String message = inputStream.readUTF();
                System.out.println("Message from client: " + message);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}