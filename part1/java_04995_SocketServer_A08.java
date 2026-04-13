import java.io.*;
import java.net.*;

public class java_04995_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // Binding to port 4444
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = server.accept(); // Establishes a connection
                System.out.println("A new client has connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF(); // Reads the message from the client
                System.out.println("Received: " + message);

                dos.writeUTF("Message received"); // Sends a response back to the client
                dos.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}