import java.io.*;
import java.net.*;

public class java_29680_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Waiting for connection...");

        Socket socket = server.accept();
        System.out.println("Connection accepted from " + socket.getInetAddress().getHostAddress());

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String message = dis.readUTF();
            System.out.println("Received: " + message);
            dos.writeUTF("Echo: " + message);
            dos.flush();
       
            if (message.equals("exit")) {
                System.out.println("Connection closed");
                socket.close();
                server.close();
                break;
            }
        }
    }
}