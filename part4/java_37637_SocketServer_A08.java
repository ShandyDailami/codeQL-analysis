import java.io.*;
import java.net.*;

public class java_37637_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started. Listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection established. Server is secure.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println(in.readUTF());

            socket.close();
        }
    }
}