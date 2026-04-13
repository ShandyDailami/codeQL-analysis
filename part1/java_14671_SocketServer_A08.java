import java.io.*;
import java.net.*;

public class java_14671_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server is running at port 8189");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMsg = in.readUTF();
                System.out.println("Client says: " + clientMsg);

                String serverMsg = "Hello, client!";
                out.writeUTF(serverMsg);
                System.out.println("Server says: " + serverMsg);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}