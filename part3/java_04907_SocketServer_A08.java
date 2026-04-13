import java.io.*;
import java.net.*;

public class java_04907_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dis.readUTF();
            System.out.println("Client says: " + clientMsg);

            String serverMsg = "Hello, client!";
            dos.writeUTF(serverMsg);
            dos.flush();
       
            socket.close();
        }
    }
}