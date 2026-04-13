import java.io.*;
import java.net.*;

public class java_09715_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while(true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();

            // A03_Injection: String manipulation to break out of program
            String newMessage = clientMessage.replace('a', 'b');

            out.writeUTF("Hello Client, your message has been changed to: " + newMessage);
            socket.close();
        }
    }
}