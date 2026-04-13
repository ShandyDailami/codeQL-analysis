import java.io.*;
import java.net.*;

public class java_19117_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

        Socket client = server.accept();
        System.out.println("Connected to " + client.getRemoteSocketAddress());

        // Create input and output streams
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        // Read the request from the client
        String request = in.readUTF();
        System.out.println("Received: " + request);

        // Echo the request back to the client
        out.writeUTF(request);
        out.flush();

        // Close the connection
        client.close();
    }
}