import java.io.*;
import java.net.*;

public class java_17795_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        // Step 1: Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Step 2: Wait for a client to connect
        Socket clientSocket = serverSocket.accept();

        // Step 3: Create input and output streams
        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

        // Step 4: Read a line from the client
        String request = input.readUTF();

        // Step 5: Process the request (security-sensitive operation)
        processRequest(request);

        // Step 6: Send a response back to the client
        output.writeUTF("Thank you for connecting to the server");

        // Step 7: Close the connection
        clientSocket.close();
        serverSocket.close();
    }

    private static void processRequest(String request) {
        // This is a placeholder for your security-sensitive operation, which is not provided in the original request.
        // Please replace it with your actual operation.
        request = request.replace("injection", "");
    }
}