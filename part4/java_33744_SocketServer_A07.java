import java.io.*;
import java.net.*;

public class java_33744_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server Started at Port: 8189");
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected: " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dataInputStream.readUTF();
            System.out.println("Received Client Message: " + clientMsg);

            String serverMsg = "Hello Client, you are connected to server!";
            dataOutputStream.writeUTF(serverMsg);
            System.out.println("Sent Server Message: " + serverMsg);

            socket.close();
        }
    }
}