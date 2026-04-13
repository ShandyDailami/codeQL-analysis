import java.io.*;
import java.net.*;

public class java_13245_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected...");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMsg = dis.readUTF();
                System.out.println("Client says: " + clientMsg);

                String serverMsg = "Hello, you are connected";
                dos.writeUTF(serverMsg);
                System.out.println("Server says: " + serverMsg);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}