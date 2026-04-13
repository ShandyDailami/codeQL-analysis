import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_09565_SocketServer_A01 {
    public static void main(String[] args) {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        try {
            // Start a new socket and port
            socket = new Socket("localhost", 6000);

            // Create input and output streams
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Send a request
            out.println("Hello, client!");

            // Read a response
            String response = in.readLine();

            // Close the connection
            socket.close();

            // Print the response
            System.out.println("Server said: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}