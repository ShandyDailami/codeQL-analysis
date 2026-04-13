import java.io.*;
import java.net.*;

public class java_08482_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message received: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            out.flush();

            socket.close();
        }
    }
}