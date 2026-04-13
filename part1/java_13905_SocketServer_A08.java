import java.io.*;
import java.net.*;

public class java_13905_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 1234;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Message from client: " + message);

                String response = "Hello Client, you're authenticated!";
                dos.writeUTF(response);
                dos.flush();
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}