import java.io.*;
import java.net.*;

public class java_06181_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Place your security-sensitive operations here.
            // For instance, let's consider a simple request to be either a valid or invalid request
            if (request.equals("valid_request")) {
                dos.writeUTF("Request accepted");
            } else {
                dos.writeUTF("Invalid request");
            }

            dos.close();
            socket.close();
        }
    }
}