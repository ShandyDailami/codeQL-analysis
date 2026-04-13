import java.io.*;
import java.net.*;

public class java_19401_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and wait for connections
            server = new ServerSocket(4444);
            System.out.println("Waiting for connections...");
            socket = server.accept();
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            // Create input and output streams
            OutputStream outToClient = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToClient);

            // Send a message to the client
            out.writeUTF("Hello client, you connected to the server!");

            // Close the streams
            out.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}