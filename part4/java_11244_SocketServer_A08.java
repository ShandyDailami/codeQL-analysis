import java.io.*;
import java.net.*;

public class java_11244_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running on port 8080");

        while (true) {
            Socket socket = server.accept();

            System.out.println("New client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Simulate a security-sensitive operation
            String response = request.toUpperCase();

            output.writeUTF(response);
            output.flush();

            socket.close();
       
        }
    }
}