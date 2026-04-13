import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class java_08254_SocketServer_A03 {
    public static void main(String[] args) {
        // Create a server socket
        try (Socket serverSocket = new Socket("localhost", 1234)) {
            System.out.println("Connected to the server");

            // Create an output stream
            try (OutputStream outputStream = serverSocket.getOutputStream()) {
                // Read from the console
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    // Write to the client
                    outputStream.write(clientMessage.getBytes());
                    outputStream.flush();

                    // Echo back to client
                    String serverMessage = "Server received: " + clientMessage;
                    outputStream.write(serverMessage.getBytes());
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}