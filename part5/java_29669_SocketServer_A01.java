import java.io.*;
import java.net.*;

public class java_29669_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // First, read and check the protocol version
            byte[] bytes = new byte[1];
            in.readFully(bytes);
            if (bytes[0] != 1) {
                out.writeBytes("Unsupported protocol version, closing connection.\n");
                out.flush();
                socket.close();
                continue;
            }

            // Then, read and check the command
            bytes = new byte[2];
            in.readFully(bytes);
            String command = new String(bytes, "UTF-8");
            if (!command.equals("PING")) {
                out.writeBytes("Unknown command, closing connection.\n");
                out.flush();
                socket.close();
                continue;
            }

            // If everything is okay, respond
            out.writeBytes("PONG\n");
            out.flush();
            socket.close();
        }
    }
}