import java.io.*;
import java.net.*;

public class java_12661_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            dos.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            dos.flush();
       
            socket.close();
        }
    }
}