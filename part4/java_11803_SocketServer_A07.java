import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_11803_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        // Setup server
        int port = 5000;
        System.out.println("Starting server on port " + port);

        while (true) {
            try (Socket socket = new Socket("localhost", port)) {
                // Setup input and output
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send request
                out.println("GET / HTTP/1.1");
                out.println("Host: localhost");
                out.println("Connection: close");
                out.println();

                // Receive and print response
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                }
            }
        }
    }
}