import java.io.*;
import java.net.*;

public class java_23561_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket server = new ServerSocket(2222);

        System.out.println("Server is listening on port 2222...");

        // Accept a client socket
        Socket client = server.accept();

        System.out.println("A client has connected...");

        // Create an input stream and an output stream
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String inputLine;

        // Get the client's message
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received client message : " + inputLine);

            // Reply the client with a message
            out.println("Server received your message: " + inputLine);
       
            // Flush the output
            out.flush();

            if (inputLine.equals("Exit")) {
                client.close();
                server.close();
            }
        }

        // Close the resources
        in.close();
        out.close();
        client.close();
        server.close();
    }
}