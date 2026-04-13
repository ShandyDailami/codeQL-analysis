import java.io.*;
import java.net.*;

public class java_24929_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Listening port
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading client's name
            String clientName = in.readUTF();
            System.out.println("Client's name: " + clientName);

            // Sending greeting to the client
            out.writeUTF("Hello, " + clientName);
            out.flush();

            // Receiving integrity failure
            int integrityFailure = in.readInt();
            System.out.println("Integrity failure: " + integrityFailure);

            // Sending confirmation
            out.writeUTF("Received integrity failure: " + integrityFailure);
            out.flush();

            socket.close();
        }
    }
}