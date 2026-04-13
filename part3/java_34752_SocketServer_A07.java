import java.io.*;
import java.net.*;

public class java_34752_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Message received: " + message);

                // Implementing simple authentication
                if ("auth".equals(message)) {
                    out.writeUTF("Auth successful");
                } else {
                    out.writeUTF("Auth failed");
                }

                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}