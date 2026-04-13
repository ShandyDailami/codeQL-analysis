import java.io.*;
import java.net.*;

public class java_24448_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while(true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            message = "Hello Client, You have connected to the server.";
            dos.writeUTF(message);
            dos.flush();

            socket.close();
        }
    }
}