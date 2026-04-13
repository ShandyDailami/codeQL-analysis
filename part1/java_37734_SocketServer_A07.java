import java.io.*;
import java.net.*;

public class java_37734_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at port 6000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Perform authentication
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read authentication request
            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Authenticate request
            if (authenticateRequest(request)) {
                // If authenticated, send response
                dos.writeUTF("Authentication successful");
                dos.flush();
            } else {
                // If not authenticated, send failure response
                dos.writeUTF("Authentication failed");
                dos.flush();
            }

            socket.close();
        }
    }

    // Simulate authentication by checking if request is "password"
    private static boolean authenticateRequest(String request) {
        return request.equals("password");
    }
}