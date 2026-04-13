import java.io.*;
import java.net.*;

public class java_33279_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 12345;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read the username from the client
                String username = in.readUTF();
                System.out.println("Received username: " + username);

                // Send a welcome message to the client
                String response = "Welcome, " + username;
                out.writeUTF(response);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}