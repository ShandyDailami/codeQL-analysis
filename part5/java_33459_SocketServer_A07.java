import java.io.*;
import java.net.*;

public class java_33459_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(4444);
            System.out.println("Waiting for client on port " + 4444);

            // Accept a client
            socket = server.accept();
            System.out.println("Accepted client at " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a greeting to the client
            out.writeUTF("Hello Client, You are Connected to Socket Server");

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Close the connections
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}