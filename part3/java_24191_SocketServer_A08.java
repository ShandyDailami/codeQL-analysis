import java.io.*;
import java.net.*;

public class java_24191_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read the request
            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            // Process the request (e.g., integrity failure)
            if (request.contains("A08_IntegrityFailure")) {
                System.out.println("Integrity failure detected, sending error response");

                // Send error response
                dataOutputStream.writeUTF("Error: integrity failure");
                dataOutputStream.flush();
            } else {
                System.out.println("Sending success response");

                // Send success response
                dataOutputStream.writeUTF("Success: request processed successfully");
                dataOutputStream.flush();
            }

            socket.close();
        }
    }
}