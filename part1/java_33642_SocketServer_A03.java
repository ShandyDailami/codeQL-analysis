import java.net.*;
import java.io.*;

public class java_33642_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for a client...");
        Socket socket = server.accept();
        System.out.println("Client accepted!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String clientMessage = in.readUTF();
        System.out.println("Client says: " + clientMessage);

        String serverMessage = "Hello, client! You've connected successfully.";
        out.writeUTF(serverMessage);
        System.out.println("Server says: " + serverMessage);

        socket.close();
    }
}