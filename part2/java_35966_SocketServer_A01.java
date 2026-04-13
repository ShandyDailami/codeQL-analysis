import java.io.*;
import java.net.*;

public class java_35966_SocketServer_A01 {
    private static int port = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Send a message to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connected to the server");

                // Receive a message from the client
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println(in.readUTF());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}