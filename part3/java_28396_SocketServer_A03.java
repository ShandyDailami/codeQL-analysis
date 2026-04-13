import java.io.*;
import java.net.*;

public class java_28396_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Server says: " + response);

            socket.close();
        }
    }
}