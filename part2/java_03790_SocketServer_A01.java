import java.net.*;
import java.io.*;

public class java_03790_SocketServer_A01 {

    private static final String[] ALLOWED_IPS = {"192.168.1.100", "192.168.1.101", "192.168.1.102"};
    private static int port = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                String clientIP = socket.getRemoteSocketAddress().toString();
                if (!isAllowed(clientIP)) {
                    System.out.println("Access denied for " + clientIP);
                    socket.close();
                    continue;
                }

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent message: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAllowed(String ip) {
        for (String allowedIp : ALLOWED_IPS) {
            if (ip.equals(allowedIp)) {
                return true;
            }
        }
        return false;
    }
}