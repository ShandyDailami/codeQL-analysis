import java.net.*;
import java.io.*;

public class java_02737_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        while (true) {
            try {
                server = new ServerSocket(8080);
                System.out.println("Server started at port 8080");
                Socket socket = server.accept();

                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMsg = in.readUTF();
                System.out.println("Client says: " + clientMsg);

                String serverMsg = "Server says: Hello Client!";
                out.writeUTF(serverMsg);
                System.out.println("Server says: " + serverMsg);

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}