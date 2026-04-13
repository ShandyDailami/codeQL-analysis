import java.io.*;
import java.net.*;

public class java_31582_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

            socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Received: " + message);
                out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}