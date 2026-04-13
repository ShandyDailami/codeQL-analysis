import java.io.*;
import java.net.*;

public class java_02434_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Reading the request from the client
            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            // Sending back a response
            String response = processRequest(request);
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();

            socket.close();
       
        }
    }

    private static String processRequest(String request) {
        // Simulate a security-sensitive operation related to Injection attacks
        // E.g., using a SQL query to insert a user into a database
        // Note: This is a simplistic example and doesn't include actual SQL operations or parameterized queries
        // Also, it doesn't include any form of sanitization or escaping of user input
        // This is a demonstration of how to perform a security-sensitive operation in a vanilla Java program
        if (request.contains("DROP TABLE")) {
            // This is a dangerous operation, so we don't allow it
            return "Operation denied";
        }
        // Simulate a database operation by inserting a user into a table
        String user = request.split(";")[0].replace("INSERT INTO users (", "");
        // Assume the user's name is "John Doe"
        // Note: This is a simplistic example, actual user input should be sanitized and parameterized
        return "User " + user + " added successfully";
    }
}