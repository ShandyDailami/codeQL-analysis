import java.io.*;
import java.net.*;

public class java_05354_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Sending back the same data to client
            output.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());
            output.flush();
        }
    }
}