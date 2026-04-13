import java.io.*;
import java.net.*;

public class java_10036_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 12345;
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Waiting for client...");
            socket = server.accept();
            System.out.println("Client accepted.");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection Established");
            while (true) {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String message = in.readUTF();
                System.out.println("Received: " + message);
                out.writeUTF("Server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}