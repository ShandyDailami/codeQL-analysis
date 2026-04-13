import java.io.*;
import java.net.*;

public class java_07375_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, you are authenticated";
            dos.writeUTF(serverMessage);

            dos.close();
            socket.close();
       
        }
    }
}