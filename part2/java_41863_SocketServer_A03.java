import java.io.*;
import java.net.*;

public class java_41863_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        OutputStream out = socket.getOutputStream();
        DataOutputStream writer = new DataOutputStream(out);

        // Here, we're sending a simple string. In a real application,
        // this could be a command or a message that needs to be sent securely.
        writer.writeUTF("Hello client, you are connected to server!");

        socket.close();
        server.close();
    }
}