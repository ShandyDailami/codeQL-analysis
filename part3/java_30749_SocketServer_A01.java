import java.io.*;
import java.net.*;

public class java_30749_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected!");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            out.writeUTF(response);
            out.flush();

            // Close the connection
            socket.close();
       
        }
    }
}