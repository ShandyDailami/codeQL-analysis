import java.io.*;
import java.net.*;

public class java_31135_SocketServer_A08 {
    private static final int PORT = 8080;
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        while (running) {
            Socket client = server.accept();
            System.out.println("Accepted connection from: " + client.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Start the socket stream security here
            // The next line of code simulates a socket security breach
            out.writeUTF("You are now connected to the server! Please note that this is a security-sensitive operation.");

            String message = in.readUTF();
            System.out.println("Server says: " + message);

            client.close();
        }
        server.close();
    }

    public static void stopServer() {
        running = false;
    }
}