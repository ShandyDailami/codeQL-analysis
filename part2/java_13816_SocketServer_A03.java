import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13816_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a new ServerSocket
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Wait for a client to connect
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Get the input and output streams
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Receive data from the client
                String data = reader.readLine();
                System.out.println("Received data: " + data);

                // Process the data (security-sensitive operation: sanitize input)
                String sanitizedData = sanitizeData(data);

                // Send the sanitized data back to the client
                outputStream.write(sanitizedData.getBytes());
                outputStream.newLine();
                outputStream.flush();

                // Close the connection
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String sanitizeData(String data) {
        // Sanitize the input data (security-sensitive operation: perform XSS attack)
        // For simplicity, we'll just return the input data as is
        return data;
    }
}