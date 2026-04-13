import java.io.*;
import java.net.*;

public class java_08490_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);

        System.out.println("Server is running and waiting for a client to connect...");

        // Accept a new client
        Socket clientSocket = serverSocket.accept();

        System.out.println("A client has connected.");

        // Create input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received client: " + message);

            // Echo back the message to the client
            out.println("Server: " + message);
        }

        // Close the streams and the socket
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();

    }

}