import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class java_20216_SocketServer_A03 {

    public static void main(String[] args) {
        Socket socket = null;

        try {
            // Create a new socket on port 12345
            socket = new Socket();
            socket.bind(new InetSocketAddress(12345));

            System.out.println("Server started on port 12345");

            // Wait for client connection
            socket.listen(5);
            socket = socket.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send message to client
            out.println("Hello, client!");

            // Read the response from the client
            String response = in.readLine();
            System.out.println("Server received: " + response);

            // Close the socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}