import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_30268_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // Step 1: Accept client connection
        Socket client = new Socket("localhost", 8080);

        // Step 2: Create InputStream and OutputStream
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter output = new PrintWriter(client.getOutputStream(), true);

        // Step 3: Receive data from client
        String message = input.readLine();
        System.out.println("Server received: " + message);

        // Step 4: Send data to client
        output.println("Server says: " + message);

        // Step 5: Close connections
        client.close();
    }
}