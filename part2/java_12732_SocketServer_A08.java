import java.io.*;
import java.net.*;

public class java_12732_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        while(true) {
            try {
                serverSocket = new ServerSocket(8080);
                System.out.println("Server Started at Port: 8080");
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String clientMsg = in.readUTF();
                System.out.println("Client says: " + clientMsg);
                String serverMsg = "Server says: Hello Client!";
                out.writeUTF(serverMsg);
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}