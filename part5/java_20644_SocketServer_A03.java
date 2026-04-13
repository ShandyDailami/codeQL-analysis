import java.io.*;
import java.net.*;

public class java_20644_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for a client...");

        Socket socket = serverSocket.accept();
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message;
        while ((message = in.readUTF()) != null) {
            System.out.println("Received: " + message);
            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
        }

        socket.close();
    }
}