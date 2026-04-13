import java.io.*;
import java.net.*;

public class java_28180_SocketServer_A01 {
    private static final int PORT = 9876;
    private static Socket socket;
    private static ServerSocket server;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) throws IOException {
        serverStart();
    }

    public static void serverStart() throws IOException {
        server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        socket = server.accept();
        System.out.println("Client connected: " + socket.getRemoteSocketAddress());

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        String clientMessage;

        while ((clientMessage = in.readUTF()) != null) {
            System.out.println("Client says: " + clientMessage);

            if (clientMessage.equalsIgnoreCase("exit")) {
                socket.close();
                server.close();
                System.out.println("Connection closed");
                break;
            }

            out.writeUTF("Server says: " + clientMessage);
            out.flush();
        }

        socket.close();
        server.close();
    }
}