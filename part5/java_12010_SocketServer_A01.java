import java.io.*;
import java.net.*;

public class java_12010_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected...");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String message;
                while (true) {
                    message = dataInputStream.readUTF();
                    System.out.println("Received message: " + message);

                    if (message.equals("exit")) {
                        System.out.println("Client disconnected...");
                        socket.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}