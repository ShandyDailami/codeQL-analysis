import java.io.*;
import java.net.*;

public class java_19089_SocketServer_A03 {
    private static int port = 12345;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            String response = "Server received your message: " + request;
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }
}