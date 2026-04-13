import java.io.*;
import java.net.*;

public class java_26655_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server started on port 6666");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String request = dis.readUTF();
                System.out.println("Received request: " + request);

                // TODO: Insert security-sensitive operations related to A03_Injection here
                // For example, sanitize the input request:
                String sanitizedRequest = sanitizeRequest(request);

                dos.writeUTF("Received and sanitized request: " + sanitizedRequest);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sanitizeRequest(String request) {
        // TODO: Implement sanitization logic
        // For example, replace certain characters with their equivalent in HTML:
        String sanitizedRequest = request.replace("<", "&lt;");
        return sanitizedRequest;
    }
}