import java.io.*;
import java.net.*;

public class java_07058_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");
        
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Create input and output streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;

        // Read from client
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Hello, client!");
        }

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}