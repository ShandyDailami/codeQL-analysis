import java.io.*;
import java.net.*;

public class java_11495_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8080);

        System.out.println("Waiting for a client...");

        Socket socket = server.accept();

        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("Connection established");

        DataInputStream in = new DataInputStream(socket.getInputStream());

        String message = in.readUTF();
        System.out.println("Received: " + message);

        out.close();
        socket.close();
        server.close();
    }
}