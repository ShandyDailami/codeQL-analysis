import java.io.*;
import java.net.*;

public class java_06889_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            if ("bad".equals(message)) {
                dos.writeUTF("Bad request, you are not authorized to access this resource");
            } else {
                dos.writeUTF("Good request, you are authorized to access this resource");
            }

            dos.flush();
            socket.close();
        }
    }
}