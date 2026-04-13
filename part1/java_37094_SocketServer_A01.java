import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_37094_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        int port = 9876;
        // Create the server
        Socket server = new Socket("localhost", port);
        System.out.println("Connected to the server");

        // Create output writer and reader
        PrintWriter out = new PrintWriter(server.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));

        // Read a message from the server
        String message = in.readLine();
        System.out.println("Received message: " + message);

        // Send a message to the server
        out.println("Hello Server!");

        // Close the resources
        in.close();
        out.close();
        server.close();
    }
}