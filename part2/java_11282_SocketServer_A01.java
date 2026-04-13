import java.net.*;
import java.io.*;

public class java_11282_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("Ban me")) {
                out.writeUTF("Access denied!");
                out.close();
            } else {
                out.writeUTF("Access granted!");
                out.close();
            }

            socket.close();
        }
    }
}