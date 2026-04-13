import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25410_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080); // Listen on port 8080
        System.out.println("Server is running on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Wait for a client to connect

            // Get the input and output streams for this client
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Read a request from the client
            byte[] request = new byte[1024];
            input.read(request);

            // Handle the request (e.g., print it)
            System.out.println("Received: " + new String(request));

            // Send a response back to the client
            String response = "Hello, client!";
            output.write(response.getBytes());

            // Close the connection
            clientSocket.close();
        }
    }
}