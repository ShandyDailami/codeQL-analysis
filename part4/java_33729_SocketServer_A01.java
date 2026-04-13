import java.io.*;
import java.net.*;

public class java_33729_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started at port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // receive a message from the client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // send a message back to the client
                dos.writeUTF("Server received your message: " + message);
                dos.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}