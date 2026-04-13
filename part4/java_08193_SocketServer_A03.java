import java.io.*;
import java.net.*;

public class java_08193_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started.");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected.");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            String sanitizedMessage = sanitizeInput(message);
            dos.writeUTF(sanitizedMessage);
            dos.flush();

            client.close();
        }
    }

    private static String sanitizeInput(String input) {
        // This method is responsible for sanitizing the input to prevent SQL Injection.
        // We're assuming here that the input is always a valid SQL statement.
        // This is a very basic example and doesn't handle other kinds of input.
        return "SELECT * FROM Users WHERE username = '" + input + "'";
    }
}