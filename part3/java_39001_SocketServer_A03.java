import java.io.*;
import java.net.*;

public class java_39001_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Listen on port 8080

        while (true) {
            Socket socket = server.accept(); // Accept a connection

            // Handle the connection
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("Echo: " + inputLine); // Echo back the input
            }

            socket.close(); // Close the connection
        }
    }
}