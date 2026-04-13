import java.io.*;
import java.net.*;

public class java_19806_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started at port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Hello client, you connected to our server!";
                dos.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}