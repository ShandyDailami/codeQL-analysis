import java.io.*;
import java.net.*;

public class java_40118_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is running and waiting for client connection");

        Socket socket = server.accept();
        System.out.println("Client connected");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = dataInputStream.readUTF();
        System.out.println("Received: " + clientMessage);

        String serverMessage = "Hello, Client!";
        dataOutputStream.writeUTF(serverMessage);
        System.out.println("Sent: " + serverMessage);

        socket.close();
        server.close();
    }
}