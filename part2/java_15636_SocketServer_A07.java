import java.io.*;
import java.net.*;

public class java_15636_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true) {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String message = dis.readUTF();
            System.out.println("Received: " + message);
            dos.writeUTF("Echo: " + message);
            dos.flush();
            socket.close();
        }
    }
}