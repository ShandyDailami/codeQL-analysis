import java.io.*;
import java.net.*;

public class java_35100_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Hello, you are authenticated!";
            out.writeUTF(serverMessage);
            out.flush();

            socket.close();
        }
    }
}