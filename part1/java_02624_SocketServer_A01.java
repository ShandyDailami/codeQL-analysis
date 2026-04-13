import java.io.*;
import java.net.*;

public class java_02624_SocketServer_A01 {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is running...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());

                String clientMessage = inputStream.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Hello, Client!";
                outputStream.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}