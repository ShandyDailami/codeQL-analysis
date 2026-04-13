import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_33740_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create server socket
            Socket serverSocket = new Socket("localhost", 8080);

            // Get input and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

            // Send request
            out.println("Hello, Client!");

            // Get response
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Close connection
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}