import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19481_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to port 8080
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());

            // Create input and output streams
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            // Read data from the client and write it back to the client
            while (true) {
                String data = input.readUTF();
                if (data.equals("exit")) {
                    break;
                }
                output.writeUTF("Hello, client. Data received: " + data);
            }

            // Close the connection
            clientSocket.close();
        }
    }
}