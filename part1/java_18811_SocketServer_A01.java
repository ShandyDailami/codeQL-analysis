import java.io.*;
import java.net.*;

public class java_18811_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received message: " + message);

                String response = "Server received your message";
                output.writeUTF(response);
                System.out.println("Sent message: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}