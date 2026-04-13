import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_17084_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a socket and get a socket input and output stream
        Socket socket = new Socket("localhost", 1234);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Step 2: Read a line from the socket input stream
        String line = in.readLine();
        System.out.println("Server says: " + line);

        // Step 3: Send a response to the client
        String response = "Hello Client, I'm your BrokenAccessServer!";
        out.println(response);

        // Close resources
        in.close();
        out.close();
        socket.close();
    }
}