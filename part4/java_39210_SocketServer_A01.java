import java.io.*;
import java.net.*;

public class java_39210_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 4444;
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Thank you for connecting to " + socket.getInetAddress().getHostAddress() + ". You sent: " + message);
                socket.close();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}