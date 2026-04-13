import java.net.*;
import java.io.*;

public class java_16419_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected at " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read client message
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send back to client
            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            out.flush();

            socket.close();
        }
    }
}