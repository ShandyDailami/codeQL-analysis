import java.io.*;
import java.net.*;

public class java_36277_SocketServer_A01 {
    private static int port = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("auth")) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
           
            }
            socket.close();
        }
    }
}