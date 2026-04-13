import java.io.*;
import java.net.*;

public class java_38758_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Reading the request from the client
            String request = input.readUTF();
            System.out.println("Received: " + request);

            // Sending a response back to the client
            String response = "Hello, Client!";
            output.writeUTF(response);

            // Closing the connection
            socket.close();
        }
    }
}