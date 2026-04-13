import java.io.*;
import java.net.*;

public class java_20584_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A new client has connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read the data from the client
            String data = in.readUTF();

            // Perform a security-sensitive operation (e.g., verify integrity of data)
            if (!verifyIntegrity(data)) {
                System.out.println("Data integrity check failed, sending error response");
                out.writeUTF("Error: Data integrity check failed");
            } else {
                System.out.println("Data integrity check passed, sending success response");
                out.writeUTF("Success: Data received is valid");
            }

            out.close();
            clientSocket.close();
        }
    }

    // This is a simple example of a security-sensitive operation. In a real-world application,
    // you would use a stronger verification method, perhaps involving hashing and cryptography,
    // but for the sake of simplicity, this example only verifies the string "Hello, World!".
    private static boolean verifyIntegrity(String data) {
        return data.equals("Hello, World!");
    }
}