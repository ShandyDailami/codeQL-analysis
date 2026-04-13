import java.io.*;
import java.net.*;

public class java_03187_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket socket = server.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            dos.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());
            dos.flush();

            socket.close();
        }
    }
}