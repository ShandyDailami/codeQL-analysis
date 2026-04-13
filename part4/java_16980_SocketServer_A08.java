import java.io.*;
import java.net.*;

public class java_16980_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6789);
            System.out.println("Waiting for client on port: " + server.getLocalPort());
            while(true) {
                Socket socket = server.accept();
                System.out.println("Connected to: " + socket.getRemoteSocketAddress());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String message = dis.readUTF();
                System.out.println("Received: " + message);
                String response = "Hello Client, your message is: " + message;
                dos.writeUTF(response);
                dos.flush();
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}