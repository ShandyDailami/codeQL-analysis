import java.io.*;
import java.net.*;

public class java_33956_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Get the message from the client
            String message = input.readUTF();
            System.out.println("Client says: " + message);

            // Simulate a security-sensitive operation using a simple injection
            // This is a simplified demonstration and not a real-world application.
            String injectedMessage = message + " Injection!";
            output.writeUTF(injectedMessage);

            socket.close();
        }
    }
}