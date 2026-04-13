import java.io.*;
import java.net.*;

public class java_26039_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client is connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Security-sensitive operation: Simulating a password-based access control
            // This is a basic example, actual implementation should be more complex
            if ("password".equals(request)) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
           
            }

            out.close();
            socket.close();
        }
    }
}