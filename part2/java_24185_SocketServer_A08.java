import java.io.*;
import java.net.*;

public class java_24185_SocketServer_A08 {
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_SOCKET_PORT = 12345;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(SERVER_SOCKET_ADDRESS, SERVER_SOCKET_PORT));

            System.out.println("Server is listening on port " + SERVER_SOCKET_PORT + "...");

            socket = serverSocket.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                if (message.equals("exit")) {
                    out.writeUTF("Goodbye!");
                    break;
                }

                out.writeUTF("Hello, client!");
            }

            out.close();
            in.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}