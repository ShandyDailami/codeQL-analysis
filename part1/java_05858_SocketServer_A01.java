import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_05858_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        // Create a server socket and listen on port 1234
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            // Accept a client connection
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Receive a line from the client and send a response
            String line = in.readLine();
            out.println("Received: " + line);
        }
    }
}