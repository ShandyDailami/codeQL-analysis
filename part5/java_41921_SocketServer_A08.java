import java.io.*;
import java.net.*;

public class java_41921_SocketServer_A08 {
    private static int port = 8080;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Perform encryption/decryption operations here...

            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            output.writeUTF("Server received your message successfully: " + message);
            output.flush();
            System.out.println("Sent: " + output.readUTF());

            socket.close();
        }
    }
}