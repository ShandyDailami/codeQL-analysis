import java.io.*;
import java.net.*;

public class java_12155_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2222);
            System.out.println("Server is listening on port 2222");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client is connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Hello client, you are authenticated";
                dos.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}