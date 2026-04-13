import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28964_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: SocketServer <message>");
            System.exit(0);
        }

        // Create a server socket
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            // Accept a new client
            Socket client = server.accept();
            System.out.println("Client accepted from " + client.getRemoteSocketAddress());

            // Create streams for communication
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Send a message to the client
            out.writeUTF(args[0] + " from server");
            out.flush();

            // Close the streams
            in.close();
            out.close();

            // Close the client connection
            client.close();
        }
    }
}