import java.io.*;
import java.net.*;

public class java_16702_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started at port 8000.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read the message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Echo the message back to the client
                out.writeUTF("Server received: " + message);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}