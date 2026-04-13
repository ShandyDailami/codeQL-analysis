import java.io.*;
import java.net.*;

public class java_17638_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            // Create streams to read and write data
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Implement A08_IntegrityFailure security-sensitive operation
            try {
                while (true) {
                    String message = in.readLine();
                    System.out.println("Received message: " + message);

                    // Check if the message is null or empty
                    if (message == null || message.isEmpty()) {
                        System.out.println("A08_IntegrityFailure detected, closing connection");
                        socket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("A08_IntegrityFailure detected, closing connection");
                socket.close();
            }
        }
    }
}