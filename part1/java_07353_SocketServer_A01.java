import java.io.*;
import java.net.*;

public class java_07353_SocketServer_A01 {
    private static final int PORT = 8080;
    private static boolean running = true;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while(running) {
                client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());

                // Perform secure operations here
                // For example, only allow authenticated clients to communicate
                if(client.getRemoteSocketAddress().equals(client.getLocalSocketAddress())) {
                    OutputStream out = client.getOutputStream();
                    PrintWriter writer = new PrintWriter(out, true);
                    writer.println("Hello, client, you are now connected to secure server!");
                } else {
                    client.close();
                }
            }

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}