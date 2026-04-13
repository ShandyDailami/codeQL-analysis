import java.io.*;
import java.net.*;

public class java_31024_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create input stream to read from client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Create output stream to write to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input;

            // Read the input from the client and echo it back
            while ((input = in.readLine()) != null) {
                out.println("Echo: " + input);
           
                // Check if client is trying to inject
                if (input.contains("script")) {
                    out.println("Sorry, but we can't accept your request. It's a security risk.");
                } else {
                    out.println("Thank you for connecting, " + input);
                }
            }

            socket.close();
        }
    }
}