import java.io.*;
import java.net.*;

public class java_18397_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
                out.flush();
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}