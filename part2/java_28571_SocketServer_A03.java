import java.io.*;
import java.net.*;

public class java_28571_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = "Message received: " + message;
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}