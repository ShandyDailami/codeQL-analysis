import java.io.*;
import java.net.*;

public class java_34725_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            // Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read a line of data from the client
            String data = dis.readUTF();
            System.out.println("Received: " + data);

            // Send a response to the client
            String response = "Server received your message";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close the connection
            socket.close();
        }
    }
}