import java.io.*;
import java.net.*;

public class java_36872_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket client = server.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // Request the client to send a message
            out.println("Please enter your name:");

            // Wait for a response
            String name = in.readLine();
            if ("exit".equals(name)) {
                break;
            }

            // Echo the response back to the client
            out.println("Hello, " + name + ", nice to meet you!");
       
        }

        server.close();
    }
}