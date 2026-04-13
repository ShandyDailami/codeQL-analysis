import java.io.*;
import java.net.*;

public class java_34185_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started at " + server.getLocalSocketAddress());

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String data = in.readUTF();
                if (checkIntegrity(data)) {
                    out.writeUTF("Integrity checked successfully. Data: " + data);
                } else {
                    out.writeUTF("Integrity check failed. Data: " + data);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIntegrity(String data) {
        // TODO: Implement integrity check logic here
        // This is a placeholder for the actual implementation
        // For the sake of simplicity, we're just returning true for all data
        return true;
    }
}