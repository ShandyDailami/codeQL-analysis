import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23473_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Assuming port 1234 is open for incoming connections.

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Waiting for a client to connect.
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Get input and output streams from the client.
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                // Here is where you would handle the data and communicate back to the client.
                // For simplicity, we'll just echo back the data.
                byte[] bytes = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(bytes)) != -1) {
                    output.write(bytes, 0, bytesRead);
                }

                // Close the connection.
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}