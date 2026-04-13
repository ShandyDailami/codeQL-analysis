import java.net.*;
import java.io.*;

public class java_31370_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);

            while(true) {
                Socket socket = server.accept();

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                dos.writeUTF("Message received");
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}