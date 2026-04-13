import java.io.*;
import java.net.*;

public class java_15141_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080); // open port 8080
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept(); // wait for client connection
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF(); // read client message
                System.out.println("Received: " + clientMessage);

                String serverMessage = "Hello, client!"; // prepare server response
                dos.writeUTF(serverMessage); // write server message

                dos.close();
                dis.close();

                System.out.println("Sent: " + serverMessage);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}