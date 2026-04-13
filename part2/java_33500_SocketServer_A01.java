import java.io.*;
import java.net.*;

public class java_33500_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(0); // Listening on any available port

        System.out.println("Server started on port " + server.getLocalPort() + ".");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection established!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Received: " + in.readUTF());

            socket.close();
        }
    }
}