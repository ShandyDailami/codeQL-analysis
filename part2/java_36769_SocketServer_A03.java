import java.io.*;
import java.net.*;

public class java_36769_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            if (clientMessage.contains(";") || clientMessage.contains("`")) {
                dos.writeUTF("You are not authorized to connect!");
                dos.flush();
                socket.close();
            } else {
                dos.writeUTF("Message received: " + clientMessage);
                dos.flush();
           
            }
            server.close();
        }
    }
}