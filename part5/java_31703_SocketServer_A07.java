import java.io.*;
import java.net.*;

public class java_31703_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("auth")) {
                out.writeUTF("auth successful");
            } else {
                out.writeUTF("auth failed");
           
            }

            socket.close();
        }
    }
}