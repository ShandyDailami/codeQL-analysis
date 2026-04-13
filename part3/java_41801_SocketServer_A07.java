import java.io.*;
import java.net.*;

public class java_41801_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for client connections...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected from " + socket.getRemoteSocketAddress());

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = dataInputStream.readUTF();
        System.out.println("Received from client: " + clientMessage);

        String serverMessage = "Hello from server!";
        dataOutputStream.writeUTF(serverMessage);
        System.out.println("Sent to client: " + serverMessage);

        socket.close();
        serverSocket.close();
    }
}