import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class java_38572_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        // Create a new server socket at port 8080
        Socket serverSocket = new Socket("localhost", 8080);

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

        // Send authentication request
        out.println("A07_AuthFailure");

        // Read the response
        String response = in.readLine();

        // Close the connection
        serverSocket.close();

        System.out.println("Server Response: " + response);
    }
}