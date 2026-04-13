import java.io.*;
import java.net.*;

public class java_24313_SocketServer_A08 {

    private static boolean running = true;

    public static void main(String[] args) {
        ServerSocket server = null;
        while (running) {
            try {
                server = new ServerSocket(54321); // Server listening port
                System.out.println("Server started at port 54321...");

                Socket socket = null;
                while (running) {
                    try {
                        socket = server.accept();
                        System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                        // Send a Welcome message
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        out.writeUTF("Welcome to the server!");

                        // Receive and print the message
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        System.out.println("Client says: " + in.readUTF());

                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        server.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}