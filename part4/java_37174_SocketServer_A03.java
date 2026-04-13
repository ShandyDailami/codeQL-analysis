import java.io.*;
import java.net.*;

public class java_37174_SocketServer_A03 {
    private static String welcomeMessage = "Welcome to the server!";

    public static void main(String[] args) {
        int port = 8080;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Write welcome message to client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(welcomeMessage);

                // Read from client
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println("Server received: " + in.readUTF());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}