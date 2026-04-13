import java.io.*;
import java.net.*;

public class java_27252_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create stream for communication
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Get client's message
                String clientMessage = input.readUTF();
                System.out.println("Client message: " + clientMessage);

                // Send back a message to the client
                String serverMessage = "Hello, client!";
                output.writeUTF(serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}