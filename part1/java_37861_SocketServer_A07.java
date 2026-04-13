import java.io.*;
import java.net.*;

public class java_37861_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                break;
            }

            out.writeUTF("Hello client, you sent: " + message);
            out.flush();
        }

        socket.close();
        server.close();
    }
}