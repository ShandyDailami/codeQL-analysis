import java.io.*;
import java.net.*;

public class java_23154_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189); // port
            System.out.println("Waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client accepted");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read from client
            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            // Send response to client
            String serverMessage = "Hello, Client!";
            out.writeUTF(serverMessage);
            System.out.println("Sent: " + serverMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}