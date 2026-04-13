import java.io.*;
import java.net.*;

public class java_42150_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected");

            // Start authentication
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientInfo = dis.readUTF();
            System.out.println("Client info: " + clientInfo);

            // In this example, let's say that the client is authenticated by providing a valid username.
            // In reality, authentication would typically involve checking a database for a username and password.
            if ("validUser".equals(clientInfo)) {
                dos.writeUTF("Authentication successful");
            } else {
                dos.writeUTF("Authentication failed");
                socket.close();
                continue;
            }

            // If authentication is successful, we can now read and write data.
            String message = dis.readUTF();
            System.out.println("Received message: " + message);
            String response = "Server: Hello " + message;
            dos.writeUTF(response);

            // Close the socket and handle other tasks here.
            socket.close();
        }
    }
}