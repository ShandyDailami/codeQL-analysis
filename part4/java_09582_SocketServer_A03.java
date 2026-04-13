import java.io.*;
import java.net.*;

public class java_09582_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client accepted!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String clientMessage = in.readUTF();
        System.out.println("Client says: " + clientMessage);

        String serverMessage = "Hello, client!";
        out.writeUTF(serverMessage);
        System.out.println("Server says: " + serverMessage);

        socket.close();
    }
}