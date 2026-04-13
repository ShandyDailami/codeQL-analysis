import java.io.*;
import java.net.*;

public class java_15305_SocketServer_A08 {
    private static int port = 8080;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            output.writeUTF("Message received");
            output.flush();

            socket.close();
        }
    }
}