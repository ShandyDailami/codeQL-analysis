import java.io.*;
import java.net.*;

public class java_39246_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received: " + request);

            String response = "Server received your message: " + request;
            output.writeUTF(response);

            clientSocket.close();
        }
    }
}