import java.io.*;
import java.net.*;

public class java_20840_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // Listening on port 1234
            System.out.println("Server is listening...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected...");

                // Create input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Get client input
                String clientInput = in.readLine();
                System.out.println("Client says: " + clientInput);

                // Do some security-sensitive operation
                // In this case, we'll just reverse the string
                String reversedInput = new StringBuilder(clientInput).reverse().toString();

                // Send back to client
                out.println("Server says: " + reversedInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}