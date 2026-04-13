import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_39652_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Create a socket and bind it to a port
            Socket socket = new Socket("localhost", 1234);

            // Get input and output streams from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read a line from the client
            String line = in.readLine();
            System.out.println("Received: " + line);

            // Send a response back to the client
            out.println("Hello, Client!");

            // Close the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}