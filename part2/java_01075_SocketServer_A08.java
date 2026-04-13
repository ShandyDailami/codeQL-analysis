import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_01075_SocketServer_A08 {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public void start(int port) {
        System.out.println("Starting server at port " + port);
        try {
            socket = new Socket("localhost", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Send a request to the server
            out.println("Hello, client!");

            // Wait for a response from the server
            String response = in.readLine();
            System.out.println("Received response: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecureServer server = new SecureServer();
        server.start(12345);
    }
}