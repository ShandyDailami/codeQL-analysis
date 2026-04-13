import java.io.*;
import java.net.*;

public class java_20255_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // create a server socket
            server = new ServerSocket(1234);
            System.out.println("Waiting for client on port: " + server.getLocalPort() + "...");

            // accept client connection
            socket = server.accept();
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            // Create InputStream and OutputStream
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read data from client and write back
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // send response
            dos.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());
            System.out.println("Sent: " + "Thank you for connecting to " + socket.getLocalSocketAddress());

            // Close the connection
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}