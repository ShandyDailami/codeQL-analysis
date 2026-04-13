import java.io.*;
import java.net.*;

public class java_17257_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);

        System.out.println("Server is listening on port 6000...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            String response = "Hello, client!";
            out.writeUTF(response);

            socket.close();
        }
    }
}