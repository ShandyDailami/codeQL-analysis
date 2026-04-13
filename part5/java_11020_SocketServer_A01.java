import java.net.*;
import java.io.*;

public class java_11020_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Create streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Handle communication with client
            String message = in.readUTF();
            out.writeUTF("Thank you for connecting to " + clientSocket.getRemoteSocketAddress() + ". Message: " + message);

            // Close streams
            in.close();
            out.close();
            clientSocket.close();
        }
    }
}