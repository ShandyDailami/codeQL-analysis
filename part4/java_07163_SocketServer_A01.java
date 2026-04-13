import java.io.*;
import java.net.*;

public class java_07163_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Listen on port 8080
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept(); // Wait for a client to connect

                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF(); // Read the client's request
                System.out.println("Received request: " + request);

                String response = "Hello, client!"; // Prepare a response
                out.writeUTF(response); // Send the response

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}