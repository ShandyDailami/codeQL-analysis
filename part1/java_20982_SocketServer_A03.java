import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_20982_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Create the server socket
        var server = new Socket("127.0.0.1", 6000);

        // Get the input and output streams
        var in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        var out = new PrintWriter(server.getOutputStream(), true);

        // Read a line from the client
        var line = in.readLine();

        while (true) {
            // Send the line back to the client
            out.println(line);

            // Wait for a line from the client
            line = in.readLine();
        }
    }
}