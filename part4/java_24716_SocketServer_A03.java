import java.io.*;
import java.net.*;

public class java_24716_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started. Waiting for client on port 8080...");

        Socket socket = serverSocket.accept();

        System.out.println("Client connected: " + socket.getRemoteSocketAddress());

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = dataInputStream.readUTF();

        System.out.println("Received: " + clientMessage);

        String serverMessage = "Hello, Client! Message received!";
        dataOutputStream.writeUTF(serverMessage);
        dataOutputStream.flush();

        socket.close();
        serverSocket.close();
    }
}