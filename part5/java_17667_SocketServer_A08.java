import java.io.*;
import java.net.*;

public class java_17667_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

        Socket client = server.accept();
        System.out.println("Connected to " + client.getRemoteSocketAddress());

        OutputStream outToClient = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToClient);
        out.writeUTF("Thank you for connecting to " + client.getLocalSocketAddress());

        InputStream inFromClient = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromClient);
        System.out.println("Received: " + in.readUTF());

        client.close();
    }
}