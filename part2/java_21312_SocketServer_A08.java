import java.io.*;
import java.net.*;

public class java_21312_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create streams
                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                // Read message from client
                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received message: " + clientMessage);

                // Send message back to client
                String serverMessage = "Hello, " + clientMessage + "!";
                dataOutputStream.writeUTF(serverMessage);

                // Close the streams
                dataInputStream.close();
                dataOutputStream.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}