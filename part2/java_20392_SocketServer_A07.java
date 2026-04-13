import java.io.*;
import java.net.*;

public class java_20392_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello, World!");
            System.out.println("Sent a message to client");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Received: " + in.readUTF());

            socket.close();
        }
    }
}