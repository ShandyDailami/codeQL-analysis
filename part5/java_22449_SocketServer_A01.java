import java.io.*;
import java.net.*;

public class java_22449_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4242);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Create Streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read the message
            String message = in.readUTF();

            // Echo back the message
            out.writeUTF(message);

            // Close the connection
            clientSocket.close();
        }
    }
}