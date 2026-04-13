import java.io.*;
import java.net.*;

public class java_28282_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for client connection...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Server received your message: " + message;
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }
}