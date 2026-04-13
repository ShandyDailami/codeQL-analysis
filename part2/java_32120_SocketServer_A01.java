import java.io.*;
import java.net.*;

public class java_32120_SocketServer_A01 {
    private static int port = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received request: " + request);

            String response = "Hello, " + request + ". Welcome to the Secure Socket Server!";
            output.writeUTF(response);
            output.flush();

            socket.close();
        }
    }
}