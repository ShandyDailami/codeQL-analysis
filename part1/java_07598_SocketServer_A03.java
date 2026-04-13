import java.io.*;
import java.net.*;

public class java_07598_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started at port: 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");
                socket.close();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}