import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26234_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Step 1: Establish a server socket
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        // Step 2: Wait for client to connect
        Socket socket = serverSocket.accept();
        System.out.println("Client connected...");

        // Step 3: Get output stream from the socket
        OutputStream outputStream = socket.getOutputStream();

        // Step 4: Read data from the client
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = reader.readLine();
        System.out.println("Received request: " + request);

        // Step 5: Send a response back to the client
        String response = "Hello, client!";
        outputStream.write(response.getBytes());
        System.out.println("Sent response: " + response);

        // Step 6: Close the connection
        socket.close();
    }
}