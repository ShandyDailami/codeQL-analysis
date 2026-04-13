import java.io.*;
import java.net.*;
import java.util.*;

public class java_22605_SocketServer_A08 {
    private static final String DISCOVERY_MESSAGE = "DISCOVERY_MESSAGE";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            if (message.equals(DISCOVERY_MESSAGE)) {
                out.writeUTF("DISCOVERY_RESPONSE");
                out.flush();
            } else {
                System.out.println("Received: " + message);
            }

            socket.close();
        }
    }
}