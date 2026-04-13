import java.io.*;
import java.net.*;

public class java_10703_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Server started on port 8000");

            while(true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read from client
                String clientMessage = dis.readUTF();
                System.out.println("Client said: " + clientMessage);

                // Echo back to client
                dos.writeUTF("Server says: " + clientMessage);
                dos.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}