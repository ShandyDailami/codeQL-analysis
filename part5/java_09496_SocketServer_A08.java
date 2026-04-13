import java.io.*;
import java.net.*;

public class java_09496_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // create a server socket
            server = new ServerSocket(4444);
            System.out.println("Waiting for client...");

            // accept client connection
            socket = server.accept();
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            // read from the socket
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // send a response
            out.writeUTF("Server: Hello Client!");

            // close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}