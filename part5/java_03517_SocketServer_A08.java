import java.io.*;
import java.net.*;

public class java_03517_SocketServer_A08 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Simulate integrity failure
            if (message.equals("fail")) {
                throw new RuntimeException("Simulated integrity failure");
            }

            out.writeUTF("Successfully processed: " + message);
            socket.close();
        }
    }
}