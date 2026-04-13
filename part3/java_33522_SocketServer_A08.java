import java.io.*;
import java.net.*;

public class java_33522_SocketServer_A08 {
    private static final int port = 9090;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client is connected: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received message: " + message);

                // Here we use the same message as response. This is a simple example for integrity failure.
                // In reality, you should use a secure communication protocol and have a way of identifying and verifying the data.
                output.writeUTF(message);
                output.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}