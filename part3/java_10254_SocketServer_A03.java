import java.io.*;
import java.net.*;

public class java_10254_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // read request from client
            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            // handle request (e.g., sanitize request before processing)
            String sanitizedRequest = requestSanitization(request);

            // send response back to client
            dataOutputStream.writeUTF(sanitizedRequest);

            socket.close();
        }
    }

    private static String requestSanitization(String request) {
        // TODO: Implement request sanitization here.
        // For now, we just return the sanitized request.
        return request;
    }
}