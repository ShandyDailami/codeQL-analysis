import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_25466_SocketServer_A03 {

    public static void main(String[] args) {
        Socket socket;
        try {
            // Create a socket on port 1234
            socket = new Socket("localhost", 1234);

            // Create buffered reader for input stream
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create print writer for output stream
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            // Send a message
            pw.println("Hello, client!");

            // Read a message from the server
            String serverMessage = br.readLine();

            // Print the server's message
            System.out.println("Server message: " + serverMessage);

            // Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}