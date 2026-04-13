import java.io.*;
import java.net.*;

public class java_25340_SocketServer_A08 {
    private static final int PORT = 9876;
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started.");

        while (running) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("DISCONNECT")) {
                running = false;
            } else {
                // Send a response back to the client
                out.writeUTF("Hello client, you connected successfully!");
            }

            socket.close();
        }

        server.close();
    }
}