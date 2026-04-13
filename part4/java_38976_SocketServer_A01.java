import java.net.*;
import java.io.*;

public class java_38976_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8000;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection established!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String message = in.readUTF();
                System.out.println("Received from client: " + message);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}