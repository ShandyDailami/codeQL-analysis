import java.io.*;
import java.net.*;

public class java_34850_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection established. Please enter your name:");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String name = in.readUTF();
                out.writeUTF("Hello " + name + ", nice to meet you!");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}