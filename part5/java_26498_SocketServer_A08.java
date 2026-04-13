import java.net.*;
import java.io.*;

public class java_26498_SocketServer_A08 {
    public static void main(String args[]) {
        int port = 1234;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while(true) {
                Socket s = server.accept();
                System.out.println("Client connected from " + s.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                // Start Handling the client
                String clientMsg = dis.readUTF();
                System.out.println("Client says: " + clientMsg);

                // Send back a message to client
                String serverMsg = "Hello Client, you connected successfully!";
                dos.writeUTF(serverMsg);

                s.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}