import java.io.*;
import java.net.*;

public class java_16754_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        // Create a socket server on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            // Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Handle client communication
            String clientMessage = dis.readUTF();
            System.out.println("Client message: " + clientMessage);

            String serverMessage = "Hello, client!";
            dos.writeUTF(serverMessage);
            System.out.println("Server message: " + serverMessage);

            // Close the connection
            socket.close();
        }
    }
}