import java.io.*;
import java.net.*;

public class java_32571_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

        Socket socket = server.accept();
        System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message = in.readUTF();
        System.out.println("Received: " + message);

        message = message.toUpperCase();
        out.writeUTF(message);
        System.out.println("Sent: " + message);

        socket.close();
    }
}