import java.io.*;
import java.net.*;

public class java_28619_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Implementing security-sensitive operations
            // Authentication
            if ("auth".equals(request)) {
                output.writeUTF("Successful authentication");
            } else {
                output.writeUTF("Failed authentication");
            }

            output.flush();
            socket.close();
        }
    }
}