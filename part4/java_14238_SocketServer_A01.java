import java.io.*;
import java.net.*;

public class java_14238_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // Binds to port 1234
        System.out.println("Server started!");

        while (true) {
            Socket socket = serverSocket.accept(); // Waits for a client to connect
            System.out.println("Client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Reads message from client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Sends message back to client
            output.writeUTF("Thank you for connecting, " + message);
            output.flush();

            socket.close();
       .
    }
}