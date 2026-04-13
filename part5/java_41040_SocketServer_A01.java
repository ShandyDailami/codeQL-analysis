import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_41040_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a server socket at port 12345
            ServerSocket serverSocket = new ServerSocket(12345);

            // Accept a connection
            Socket socket = serverSocket.accept();

            // Read from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Write to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String input;
            while ((input = reader.readLine()) != null) {
                System.out.println("Received: " + input);

                // Simulate a security-sensitive operation
                if (input.equals("denyaccess")) {
                    writer.println("Access Denied");
                } else {
                    writer.println("Access Granted");
                }
            }

            // Close the connections
            writer.close();
            reader.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}