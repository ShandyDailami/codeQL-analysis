import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37908_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Get input and output streams
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                break;
            }

            // Send the message back to the client
            output.write(bytesRead);
            output.flush();

            // Close the connection
            clientSocket.close();
        }

        serverSocket.close();
    }
}