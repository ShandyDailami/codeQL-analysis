import java.io.*;
import java.net.*;

public class java_12431_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client is connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Check if the message is "exit" to terminate the connection
            if (message.equals("exit")) {
                System.out.println("Connection closed by client");
                socket.close();
                break;
            }

            // Send a response back to the client
            out.writeUTF("Hello, client!");
            out.flush();
            System.out.println("Sent message: " + "Hello, client!");
        }

        serverSocket.close();
    }
}