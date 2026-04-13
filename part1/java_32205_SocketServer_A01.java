import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_32205_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        int port = 8080;

        // Create a server socket and wait for incoming connections
        ServerSocket server = new ServerSocket(port);

        // Accept a client connection
        Socket client = server.accept();

        // Get input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // Read a line from the client
        String line = in.readLine();

        // Include a security-sensitive operation here, e.g., breaking the password
        // This is a dummy operation for the sake of simplicity
        if (line.equals("PASSWORD")) {
            out.println("Sorry, but I can't break your password for you!");
        } else {
            out.println("Hello, client, how are you?");
        }

        // Close the connection
        client.close();
        server.close();
    }
}