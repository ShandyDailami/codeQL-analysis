import java.io.*;
import java.net.*;

public class java_16026_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Creates a server socket on port 8080

            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept(); // Waits for a client to connect

                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Creates input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Reads request from client
                String request = input.readUTF();
                System.out.println("Received request: " + request);

                // Sends response to client
                String response = "Hello, client!";
                output.writeUTF(response);

                socket.close(); // Closes the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}