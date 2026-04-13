import java.io.*;
import java.net.*;

public class java_12466_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String clientMessage = input.readUTF();
        System.out.println("Client says: " + clientMessage);

        String serverMessage = "Hello, client!";
        output.writeUTF(serverMessage);
        System.out.println("Server says: " + serverMessage);

        socket.close();
        serverSocket.close();
    }
}