import java.io.*;
import java.net.*;

public class java_40609_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + 8189);

        Socket socket = serverSocket.accept();

        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message = in.readUTF();
        System.out.println("Client says: " + message);

        out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
        out.close();
        in.close();

        socket.close();
        serverSocket.close();
    }
}