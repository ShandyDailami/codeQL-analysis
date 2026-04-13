import java.io.*;
import java.net.*;
import java.util.*;

public class java_17871_SocketServer_A07 {
    private static final int PORT = 8080;
    private static boolean stopServer = false;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (!stopServer) {
                Socket socket = server.accept();
                System.out.println("Client accepted: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Server received your message: " + message);
                out.flush();
                System.out.println("Sent: " + "Server received your message: " + message);

                socket.close();
            }

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        stopServer = true;
    }
}