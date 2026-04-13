import java.io.*;
import java.net.*;

public class java_31810_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // Receive and sanitize input
            String input = dis.readUTF();

            // Echo the input back to the client
            dos.writeUTF("Hello, " + input);
            dos.flush();

            client.close();
        }
    }
}