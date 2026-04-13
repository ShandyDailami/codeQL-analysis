import java.io.*;
import java.net.*;

public class java_08847_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            // Handshake
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Write response
            out.writeUTF("Hello client, you are connected!");
            out.flush();

            // Receive request
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Close connection
            socket.close();
        }
    }
}