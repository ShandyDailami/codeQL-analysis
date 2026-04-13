import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_31009_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("localhost", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Send a request
            out.println("Is this a secure connection? (y/n)");
            String response = in.readLine();

            // Check if the server's response is affirmative
            if ("y".equalsIgnoreCase(response)) {
                System.out.println("Server is affirmative, continuing...");
            } else {
                System.out.println("Server is not affirmative, shutting down...");
                socket.close();
                return;
            }

            // Send a second request
            out.println("Hello, world!");

            // Read the server's response
            String serverResponse = in.readLine();
            System.out.println("Server Response: " + serverResponse);
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}