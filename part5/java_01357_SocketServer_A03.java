import java.io.*;
import java.net.*;

public class java_01357_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String clientMsg = in.readUTF();
        System.out.println("Client says: " + clientMsg);

        String serverMsg = "Hello, client!";
        out.writeUTF(serverMsg);
        System.out.println("Server says: " + serverMsg);

        socket.close();
    }

}