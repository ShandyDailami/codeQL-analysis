import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_30580_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Create a server socket and wait for a client to connect
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Waiting for client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Get input and output streams
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        // Read from the client and send a response
        String request = reader.readLine();
        System.out.println("Received request: " + request);

        String response = "Hello, client!";
        writer.println(response);

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}