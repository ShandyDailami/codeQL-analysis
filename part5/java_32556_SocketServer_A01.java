import java.io.*;
import java.net.*;

public class java_32556_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for connection on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected...");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive a message from client
            String message = dis.readUTF();
            System.out.println("Received message from client: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Sent response to client: " + response);

            // Close the connection
            socket.close();
        }
    }
}