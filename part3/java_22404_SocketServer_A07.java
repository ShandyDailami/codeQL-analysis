import java.io.*;
import java.net.*;

public class java_22404_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // create a server socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            // accept the connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // create input and output streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // read the message from the client
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // check if the client wants to talk
            if (message.equals("Hello, Client!")) {
                // send a response
                out.writeUTF("Hello, Server!");
            } else {
                System.out.println("Invalid message from client!");
            }

            // close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}