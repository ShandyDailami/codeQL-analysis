import java.io.*;
import java.net.*;

public class java_26414_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            Socket socket = server.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String message = dis.readUTF();
            System.out.println("Received message: " + message);
            dos.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}