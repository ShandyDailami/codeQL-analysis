import java.io.*;
import java.net.*;

public class java_02507_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // listen on port 8080
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // wait for client
            System.out.println("New client connected");

            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());

            String clientMessage = input.readUTF(); // read client message
            System.out.println("Received message from client: " + clientMessage);

            String serverMessage = "Hello, client!"; // send back a response
            output.writeUTF(serverMessage);

            clientSocket.close();
        }
    }
}