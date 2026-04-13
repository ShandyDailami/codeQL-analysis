import java.io.*;
import java.net.*;

public class java_02491_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345); // create server socket
        System.out.println("Server is running on port 12345");

        while (true) {
            Socket socket = serverSocket.accept(); // accept client connection
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // read message from client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // send acknowledgment back to client
            output.writeUTF("Message received: " + message);
            output.flush();

            socket.close(); // close connection
        }
    }
}