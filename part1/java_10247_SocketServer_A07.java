import java.io.*;
import java.net.*;

public class java_10247_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);

        while (true) {
            Socket socket = serverSocket.accept();

            // Establish new streams for communication with client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String inputLine;

            // Send an encrypted welcome message
            out.println("Hello, client. You are now authenticated.");

            // Listen for a message and respond
            while ((inputLine = in.readLine()) != null) {
                out.println("Received: " + inputLine);

                // Check for auth failure
                if (inputLine.equals("bad")) {
                    out.println("Server: Authentication failed. Session closed.");
                    out.close();
                    socket.close();
                }
            }
        }
    }
}