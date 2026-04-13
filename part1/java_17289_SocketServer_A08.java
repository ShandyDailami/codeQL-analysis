import java.io.*;
import java.net.*;

public class java_17289_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received: " + message);

                output.writeUTF("Message received");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}