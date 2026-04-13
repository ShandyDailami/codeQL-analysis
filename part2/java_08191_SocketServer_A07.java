import java.io.*;
import java.net.*;

public class java_08191_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            if ("auth".equals(message)) {
                output.writeUTF("Authentication successful");
            } else {
                output.writeUTF("Authentication failed");
           
            }
            socket.close();
        }
    }
}