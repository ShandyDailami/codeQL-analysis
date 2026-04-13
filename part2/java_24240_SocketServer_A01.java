import java.io.*;
import java.net.*;

public class java_24240_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for connections on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Read the request from the client
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Process the request (This is where the security vulnerability is)
            // Here, we're just echoing back the request
            String response = request;

            // Send the response back to the client
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println(response);

            // Close the socket connection
            socket.close();
        }
    }
}