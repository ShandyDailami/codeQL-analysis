import java.io.*;
import java.net.*;

public class java_18678_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for a client...");

        Socket socket = server.accept();
        System.out.println("Connected to: " + socket.getRemoteSocketAddress());

        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        String response = "Hello, client!";
        dos.writeUTF(response);
        dos.flush();

        socket.close();
        server.close();
    }
}