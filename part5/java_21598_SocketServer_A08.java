import java.io.*;
import java.net.*;

public class java_21598_SocketServer_A08 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9090)) {
            System.out.println("Server started. Listening for connections on port 9090.");

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    String message;
                    while ((message = in.readUTF()) != null) {
                        System.out.println("Received: " + message);

                        // Check integrity
                        if (message.startsWith("Banana")) {
                            out.writeUTF("Integrity failure detected. Stopping connection.");
                            socket.close();
                            System.out.println("Stopped connection due to integrity failure.");
                            break;
                        }

                        out.writeUTF(message);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}