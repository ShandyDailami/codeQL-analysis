import java.io.*;
import java.net.*;

public class java_39988_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String message = "Hello from server";
                out.writeUTF(message);

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String received = in.readUTF();
                System.out.println("Client says: " + received);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}