import java.io.*;
import java.net.*;

public class java_40830_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String message = dataInputStream.readUTF();
        System.out.println("Received: " + message);

        String response = "Hello, client!";
        dataOutputStream.writeUTF(response);

        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        serverSocket.close();
    }

}