import java.io.*;
import java.net.*;

public class java_28782_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a socket on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create a new socket for the client
            Socket newSocket = new Socket(clientSocket.getInetAddress(), 12346);

            // Create input and output streams
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(newSocket.getOutputStream());

            // Read from the client and write to the new socket
            while (true) {
                String message = input.readUTF();
                if (message.equals("exit")) break;
                output.writeUTF(message);
                output.flush();
            }

            // Close the sockets
            clientSocket.close();
            newSocket.close();
        }
    }
}