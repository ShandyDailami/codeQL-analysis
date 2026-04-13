import java.io.*;
import java.net.*;

public class java_30910_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running and waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String request = input.readUTF();
        System.out.println("Received request: " + request);

        // Simulate authentication failure
        if ("authFailed".equals(request)) {
            output.writeUTF("A07_AuthFailure");
            System.out.println("Authentication failed. Sending message: A07_AuthFailure");
        } else {
            output.writeUTF("Successful authentication");
            System.out.println("Authentication successful");
        }

        output.close();
        socket.close();
        serverSocket.close();
    }
}