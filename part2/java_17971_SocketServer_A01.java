import java.io.*;
import java.net.*;

public class java_17971_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 8000;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Request for a username
                String request = in.readUTF();

                // Check if the request is a valid username
                if ("admin".equals(request)) {
                    out.writeUTF("Access granted");
                } else {
                    out.writeUTF("Access denied");
                }

                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}