import java.io.*;
import java.net.*;

public class java_04753_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            String response = processRequest(request);

            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // TODO: Implement security-sensitive operations here.
        // For example, you can hash the request using SHA-256

        // For simplicity, we'll just return the original request
        return request;
    }
}