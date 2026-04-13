import java.io.*;
import java.net.*;

public class java_11304_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Waiting for a client...");

        Socket socket = serverSocket.accept();

        System.out.println("Connected to the client!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = dataInputStream.readUTF();
        System.out.println("Client says: " + clientMessage);

        String serverMessage = "Hello, client!";
        dataOutputStream.writeUTF(serverMessage);
        System.out.println("Server says: " + serverMessage);

        socket.close();
    }
}