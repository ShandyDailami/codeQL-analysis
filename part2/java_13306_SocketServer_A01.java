import java.io.*;
import java.net.*;

public class java_13306_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive a message
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send a message back
                String response = "Hello, client, you connected successfully!";
                out.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}