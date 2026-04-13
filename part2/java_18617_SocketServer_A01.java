import java.io.*;
import java.net.*;

public class java_18617_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345); // 12345 is the port number
            System.out.println("Server started at port 12345");

            while (true) {
                Socket socket = server.accept(); // Waiting for client
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Receive and send message
                String message = dis.readUTF();
                System.out.println("Message from client: " + message);

                String response = "Hello, client!";
                dos.writeUTF(response);
                System.out.println("Message sent to client: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}