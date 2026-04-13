import java.io.*;
import java.net.*;

public class java_08652_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Receive request
                String request = input.readUTF();
                System.out.println("Received request: " + request);

                // Send response
                String response = "Hello, client!";
                output.writeUTF(response);
                System.out.println("Sent response: " + response);

                // Close connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}