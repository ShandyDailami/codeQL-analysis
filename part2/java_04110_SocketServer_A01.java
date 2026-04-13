import java.io.*;
import java.net.*;

public class java_04110_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message = in.readUTF();
        System.out.println("Received: " + message);

        out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
        out.flush();

        socket.close();
    }
}