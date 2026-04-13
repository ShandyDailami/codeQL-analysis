import java.io.*;
import java.net.*;

public class java_40038_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // This line does not include any security-sensitive operations.
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
            dos.flush();

            socket.close();
        }
    }
}