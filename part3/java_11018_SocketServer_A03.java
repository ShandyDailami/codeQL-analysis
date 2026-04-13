import java.io.*;
import java.net.*;

public class java_11018_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        // Create a socket server at port 9876
        ServerSocket server = new ServerSocket(9876);
        System.out.println("Server is listening on port 9876...");

        while (true) {
            // Establish a connection
            Socket socket = server.accept();

            // Create input and output stream
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String inputLine;

            // Read message from client
            while ((inputLine = in.readLine()) != null) {
                // Responds the client message
                out.println("Hello, " + inputLine + " - Message from server!");
            }

            // Close the connection
            socket.close();
        }
    }
}