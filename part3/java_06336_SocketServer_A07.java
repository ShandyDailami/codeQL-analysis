import java.io.*;
import java.net.*;
import java.util.*;

public class java_06336_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // AuthFailure is a security-sensitive operation
                // Here we're just echoing the message back
                String response = message;

                dos.writeUTF(response);
                dos.flush();
                System.out.println("Sent: " + response);

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}