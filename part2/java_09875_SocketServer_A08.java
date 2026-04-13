import java.io.*;
import java.net.*;

public class java_09875_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 4445;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected " + socket.getRemoteSocketAddress());

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                String message = "Hello, Client";
                outputStream.writeUTF(message);

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                String response = inputStream.readUTF();
                System.out.println("Server received: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}