import java.io.*;
import java.net.*;

public class java_21089_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for a client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = dataInputStream.readUTF();
        System.out.println("Received: " + clientMessage);

        String serverMessage = "Hello, client!";
        dataOutputStream.writeUTF(serverMessage);
        System.out.println("Sent: " + serverMessage);

        socket.close();
        serverSocket.close();
    }
}