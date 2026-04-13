import java.io.*;
import java.net.*;

public class java_02075_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started, waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String clientMessage = input.readUTF();
        System.out.println("Received message from client: " + clientMessage);

        String serverMessage = "Hello client, you connected!";
        output.writeUTF(serverMessage);

        socket.close();
    }
}