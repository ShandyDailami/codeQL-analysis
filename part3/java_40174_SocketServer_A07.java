import java.io.*;
import java.net.*;

public class java_40174_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080); // Listen on port 8080
            System.out.println("Server is listening on port 8080");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create an input stream from the socket and a buffer
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read the client's message
                String clientMessage = in.readUTF();
                System.out.println("Received message from client: " + clientMessage);

                // Send a welcome message back
                String serverMessage = "Welcome to the server!";
                out.writeUTF(serverMessage);
                System.out.println("Sent message to client: " + serverMessage);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}