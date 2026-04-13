import java.io.*;
import java.net.*;

public class java_39844_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started at port 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection established");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}