import java.io.*;
import java.net.*;
import java.util.*;

public class java_38148_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            if (!isValid(message)) {
                System.out.println("Invalid message, disconnecting...");
                dataOutputStream.writeUTF("Invalid message");
                dataOutputStream.flush();
                socket.close();
                continue;
            }

            String response = "Server received message: " + message;
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();

            System.out.println("Sent message: " + response);
            socket.close();
        }
    }

    private static boolean isValid(String message) {
        // Place your own logic here for checking the integrity of the message
        // This is just a placeholder for demonstration purposes
        return message.length() > 0 && message.length() < 1000;
    }
}