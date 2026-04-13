import java.io.*;
import java.net.*;

public class java_31634_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started at port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String response = "Hello, client from Socket Server!";
                out.writeUTF(response);

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}