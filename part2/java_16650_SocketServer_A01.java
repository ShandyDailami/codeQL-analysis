import java.io.*;
import java.net.*;

public class java_16650_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}