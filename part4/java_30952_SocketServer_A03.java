import java.net.*;
import java.io.*;

public class java_30952_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for a client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String clientMessage = dis.readUTF();
        System.out.println("Client says: " + clientMessage);

        String serverMessage = "Hello, client!";
        dos.writeUTF(serverMessage);
        System.out.println("Server says: " + serverMessage);

        socket.close();
    }
}