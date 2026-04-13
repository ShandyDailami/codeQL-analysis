import java.io.*;
import java.net.*;

public class java_17281_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            Socket socket = server.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            // Read client data and echo back
            while ((inputLine = in.readLine()) != null) {
                out.println("Echo: " + inputLine);
            }

            // Close the connection
            socket.close();
        }
    }
}