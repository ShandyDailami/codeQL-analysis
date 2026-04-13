import java.io.*;
import java.net.*;

public class java_24705_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}