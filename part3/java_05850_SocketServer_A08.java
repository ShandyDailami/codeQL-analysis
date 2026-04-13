import java.net.*;
import java.io.*;

public class java_05850_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080, 50000, null);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            socket.close();
        }
    }
}