import java.io.*;
import java.net.*;

public class java_37592_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read from the client
            String message = in.readLine();

            // Handle the message
            if (message != null && message.equals("exit")) {
                // If client sends "exit", close the connection
                out.println("Connection closed");
                clientSocket.close();
            } else {
                // If client sends a message, send the same message back
                out.println("Server says: " + message);
            }
        }
    }
}