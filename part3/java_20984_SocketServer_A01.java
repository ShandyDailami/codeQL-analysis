import java.io.*;
import java.net.*;

public class java_20984_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Step 1: Create the server socket
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is running...");

        // Step 2: Accept incoming connection
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Step 3: Create input stream from the socket
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        // Step 4: Read from the client
        String message = reader.readLine();
        System.out.println("Received: " + message);

        // Step 5: Send a response
        String response = "Hello, Client!";
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream, true);
        writer.println(response);

        // Step 6: Close the connection
        socket.close();
    }
}