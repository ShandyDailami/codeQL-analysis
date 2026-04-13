import java.io.*;
import java.net.*;

public class java_03603_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345); // listen on port 12345
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = serverSocket.accept(); // wait for client connection
            System.out.println("Client connected");

            // read request from client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // send response back to client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String response = "Hello, Client!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            // close connection
            socket.close();
        }
    }
}