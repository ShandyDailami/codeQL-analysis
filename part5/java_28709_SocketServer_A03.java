import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_28709_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Create a new server socket at port 8080
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(8080);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create a reader to read from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a writer to write to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read a line of text from the client
            String message = in.readLine();

            // Echo back the message to the client
            out.println(message);

            // Close the connection
            clientSocket.close();
        }
    }
}