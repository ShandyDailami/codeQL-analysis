import java.net.*;
import java.io.*;

public class java_19737_SocketServer_A01 {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(4444);
            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String clientMessage = dis.readUTF();
                System.out.println("Client says: " + clientMessage);
                String serverMessage = "Hello Client, You are connected!";
                dos.writeUTF(serverMessage);
                dos.flush();
                socket.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}