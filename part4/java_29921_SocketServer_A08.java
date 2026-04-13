import java.io.*;
import java.net.*;

public class java_29921_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received: " + request);

            // Process the request here
            // For now, let's just respond with a simple message
            String response = "Hello, client";

            output.writeUTF(response);
            output.flush();
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}