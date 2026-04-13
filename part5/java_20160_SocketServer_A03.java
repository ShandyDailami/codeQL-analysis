import java.io.*;
import java.net.*;

public class java_20160_SocketServer_A03 {
    public static void main(String args[]) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and accept a connection
            server = new ServerSocket(5000);
            System.out.println("Waiting for client connection...");
            socket = server.accept();
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read a string from the client
            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            // Echo the message back to the client
            dos.writeUTF("Echo: " + message);
            dos.flush();

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}