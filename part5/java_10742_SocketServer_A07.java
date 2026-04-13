import java.io.*;
import java.net.*;

public class java_10742_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input stream and output stream for communication
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Get request from client
            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Process the request
            // For simplicity, let's just check if the request is "auth"
            if ("auth".equals(request)) {
                // Generate response
                String response = "AuthSuccess";
                dos.writeUTF(response);
            } else {
                // If request is not "auth", return error response
                String response = "AuthFailure";
                dos.writeUTF(response);
            }

            dos.flush();
            socket.close();
        }
    }
}