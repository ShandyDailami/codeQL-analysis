import java.net.*;
import java.io.*;

public class java_39190_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 6000;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while(true) {
                Socket socket = server.accept();
                System.out.println("A new client is connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
                socket.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}