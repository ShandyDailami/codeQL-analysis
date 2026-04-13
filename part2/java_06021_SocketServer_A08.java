import java.io.*;
import java.net.*;

public class java_06021_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server started on port 8888");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                // In a real-world scenario, you should handle the message and send a response to the client

                // This is a simple example of the integrity check
                // In a real-world scenario, you should use a stronger and more secure method for integrity checking
                if (clientMessage.equals("A08_IntegrityFailure")) {
                    writer.println("IntegrityFailureHandled");
                } else {
                    writer.println("UnknownMessage");
                }
            }

            socket.close();
        }
    }
}