import java.net.*;
import java.io.*;

public class java_11629_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while(true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection established with " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Client says: " + in.readUTF());

            socket.close();
        }
    }

}