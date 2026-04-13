import java.io.*;
import java.net.*;

public class java_33761_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(4444);
            System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

            socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            String message, response;

            // RECEIVE MESSAGE FROM CLIENT
            message = in.readUTF();
            System.out.println("RECEIVED: " + message);

            // SIMULATE INJECTING SQL
            // This is a simplistic example, real-world applications would use a more secure method.
            String injected = "'; DROP TABLE users; --";
            message += injected;
            System.out.println("SENDING: " + message);
            out.writeUTF(message);

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}