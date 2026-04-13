import java.io.*;
import java.net.*;

public class java_08870_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // default port
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request from client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Proceed with request (e.g., authenticate user)
            // In reality, you would use a more complex authentication method
            if (request.equals("auth")) {
                String username = in.readUTF();
                String password = in.readUTF();

                // For the sake of example, we will just check if the password is correct
                if (username.equals("admin") && password.equals("password")) {
                    out.writeUTF("Authentication successful");
                } else {
                    out.writeUTF("Authentication failed");
                }
            }

            out.close();
            socket.close();
        }
    }
}