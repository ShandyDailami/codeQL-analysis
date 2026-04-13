import java.io.*;
import java.net.*;

public class java_05344_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Waiting for a client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client accepted!");

        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

        String clientMessage = dataInputStream.readUTF();
        System.out.println("Client says: " + clientMessage);

        String serverMessage = "Hello, client!";
        dataOutputStream.writeUTF(serverMessage);

        clientSocket.close();
        serverSocket.close();
    }
}