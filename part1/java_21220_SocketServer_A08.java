import java.io.*;
import java.net.*;

public class java_21220_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 12345;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection established!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println("Message from client: " + in.readUTF());
            }
        } catch (IOException ex) {
            System.out.println("IOException in Server: " + ex.getMessage());
        }
    }
}