import java.io.*;
import java.net.*;

public class java_24079_SocketServer_A08 {
    private static int port = 6666;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Message received: " + message);

                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Message sent: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}