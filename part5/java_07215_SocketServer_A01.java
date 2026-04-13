import java.io.*;
import java.net.*;

public class java_07215_SocketServer_A01 {
    private static int port = 1234;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running and waiting for client connections on port " + port);

            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Receive a message from client
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Send a response back to client
            String response = "Server response";
            output.writeUTF(response);

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
       
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}