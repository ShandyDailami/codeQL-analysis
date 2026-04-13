import java.io.*;
import java.net.*;

public class java_26946_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // listen on port 1234
            while (true) {
                Socket socket = server.accept(); // wait for client connection
                System.out.println("Client connected");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF(); // read client's message
                System.out.println("Message from client: " + message);

                dos.writeUTF("Thank you for connecting to " + socket.getInetAddress() + " : " + message);
                socket.close(); // close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}