import java.io.*;
import java.net.*;

public class java_32797_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running and waiting for connections on port " + 8080);

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Connection established with " + clientSocket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = "Server: " + message;
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            clientSocket.close();
        }
    }
}