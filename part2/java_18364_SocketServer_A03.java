import java.io.*;
import java.net.*;

public class java_18364_SocketServer_A03 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received message: " + message);

                // You can use the following code snippet for security-sensitive operations related to A03_Injection
                // It's not mandatory to use these operations, just for demonstration
                // String cleanMessage = message.replace("<", "&lt;").replace(">", "&gt;");

                dos.writeUTF("Thank you for connecting, message: " + message);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}