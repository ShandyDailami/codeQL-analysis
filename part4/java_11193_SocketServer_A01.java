import java.io.*;
import java.net.*;

public class java_11193_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client on port " + 8080);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Client says: " + message);

            message = "Hello Client, I'm the server!";
            output.writeUTF(message);
            System.out.println("Server says: " + message);

            clientSocket.close();
        }
    }
}