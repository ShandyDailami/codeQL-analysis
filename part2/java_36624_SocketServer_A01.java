import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_36624_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        int port = 8080;

        // Create a server socket
        Socket socket = new Socket("localhost", port);

        // Get the input and output streams
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Send a request
        out.println("GET / HTTP/1.1");
        out.println("Host: localhost");
        out.println();

        // Read the response
        String response;
        while ((response = in.readLine()) != null) {
            System.out.println(response);
        }

        // Close the connection
        socket.close();
    }
}