import java.io.*;
import java.net.*;

public class java_39696_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Request received: " + request);

            String response = processRequest(request);

            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // Simulate security-sensitive operation
        // In real world, you would use a secure way to process the request,
        // like parameterized queries or prepared statements with prepared statements
        // Also, consider using the Java Cryptography Architecture (JCA)
        // to protect against injection attacks

        // This is a placeholder operation, replace with real operation
        return "Response from server: " + request;
    }
}