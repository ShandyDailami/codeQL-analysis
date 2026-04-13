import java.io.*;
import java.net.*;

public class java_04254_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message received: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());
            socket.close();
        }
    }
}