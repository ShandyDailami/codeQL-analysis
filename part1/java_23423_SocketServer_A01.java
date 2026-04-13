import java.io.*;
import java.net.*;

public class java_23423_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            if (request.equals("exit")) {
                out.writeUTF("Exited successfully");
                socket.close();
            } else {
                out.writeUTF("Unknown request");
            }

            out.close();
            in.close();
        }
    }
}