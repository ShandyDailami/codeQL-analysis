import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01540_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A new client is connected: " + clientSocket.getInetAddress().getHostAddress());

            // Create input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream writer = clientSocket.getOutputStream();

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Send back the received message to the client
                writer.write(message.toUpperCase().getBytes());
                writer.newLine();
                writer.flush();
            }

            // Close the connections
            clientSocket.close();
        }
    }
}