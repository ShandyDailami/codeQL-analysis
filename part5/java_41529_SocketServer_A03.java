import java.io.*;
import java.net.*;

public class java_41529_SocketServer_A03 {
    private static int port = 6000;
    private static ServerSocket server;

    public static void main(String args[]) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket s = server.accept();
                System.out.println("Connected to " + s.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Simple command-line command injection
                Runtime.getRuntime().exec(message);

                dos.writeUTF("Successfully processed the message: " + message);
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}