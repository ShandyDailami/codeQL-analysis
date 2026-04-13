import java.io.*;
import java.net.*;

public class java_05127_SocketServer_A08 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();

            System.out.println("Received message: " + message);

            out.writeUTF("Successfully processed the message");
            out.flush();

            socket.close();
        }
    }
}