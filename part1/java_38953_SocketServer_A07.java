import java.io.*;
import java.net.*;

public class java_38953_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started!");

            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                String response = "Hello client!";
                dos.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}