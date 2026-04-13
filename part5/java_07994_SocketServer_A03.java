import java.net.*;
import java.io.*;

public class java_07994_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 1234;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running at port: " + port);
            
            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Server says: Hello, Client!";
                dos.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}