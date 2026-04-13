import java.io.*;
import java.net.*;

public class java_18700_SocketServer_A08 {
    private static final String SERVER_NAME = "Server";
    private static final int SERVER_PORT = 8080;
    private static Socket socket;
    private static ServerSocket server;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(SERVER_PORT);
            System.out.println("Server started at: " + new Date());
            socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = in.readUTF()) != null) {
                System.out.println("Client says: " + clientMessage);
                if (clientMessage.equalsIgnoreCase("exit")) {
                    socket.close();
                } else {
                    out.writeUTF("Server says: " + clientMessage);
                    out.flush();
                }
            }

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}