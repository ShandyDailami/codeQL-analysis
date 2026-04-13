import java.io.*;
import java.net.*;

public class java_17303_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received message: " + message);

                // Sever is sending a message back to the client
                output.writeUTF("Message received. Thanks for connecting!");
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}