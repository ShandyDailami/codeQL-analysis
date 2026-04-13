import java.io.*;
import java.net.*;

public class java_21710_SocketServer_A08 {
    private static final String QUIT = "quit";
    private static ServerSocket server;
    private static boolean running = true;

    public static void main(String[] args) {
        new SocketServer();
    }

    public java_21710_SocketServer_A08() {
        try {
            server = new ServerSocket(8189);
            while (running) {
                handleClient(server.accept());
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket client) {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                if (message.equals(QUIT)) {
                    out.writeUTF("Client has disconnected");
                    running = false;
                } else {
                    out.writeUTF("Server received: " + message);
                }
                out.flush();
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}