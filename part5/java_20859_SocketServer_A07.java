import java.io.*;
import java.net.*;

public class java_20859_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            Socket socket = server.accept();

            // Receive a message from the client
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String message = dis.readUTF();

            // Send a response back to the client
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String response = "Hello, client, you sent the following message: " + message;
            dos.writeUTF(response);

            socket.close();
        }
    }
}