import java.io.*;
import java.net.*;

public class java_27551_SocketServer_A08 {
    private static int port = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Handle client request
            String request = input.readUTF();
            System.out.println("Received: " + request);

            // Respond to the client
            String response = "Hello, " + request + ". Welcome!";
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}