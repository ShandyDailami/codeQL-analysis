import java.net.*;
import java.io.*;

public class java_23126_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 6000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello client, you are connected to server!");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}