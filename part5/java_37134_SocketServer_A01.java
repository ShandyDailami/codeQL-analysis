import java.io.*;
import java.net.*;

public class java_37134_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Connected to the client");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Reading data from client
        String clientData = dis.readUTF();
        System.out.println("Client Data: " + clientData);

        // Sending data to client
        String serverData = "Hello Client, You are connected to Broken Access Server!";
        dos.writeUTF(serverData);
        System.out.println("Server Data: " + serverData);

        socket.close();
    }
}