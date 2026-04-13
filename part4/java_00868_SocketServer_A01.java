import java.io.*;
import java.net.*;

public class java_00868_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            dos.writeUTF("Message received, thank you!");
            dos.flush();

            socket.close();
       .
.
.
.
        }
    }
}