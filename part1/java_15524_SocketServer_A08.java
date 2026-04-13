import java.io.*;
import java.net.*;

public class java_15524_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        while (true) {
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String request = dis.readUTF();
            System.out.println("Client says: " + request);
            String response = "Hello from Server";
            dos.writeUTF(response);
            dos.flush();
            socket.close();
       
        }
    }
}