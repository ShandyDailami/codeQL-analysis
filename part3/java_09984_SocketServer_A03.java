import java.io.*;
import java.net.*;

public class java_09984_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive and echo the request
            String request = in.readLine();
            out.println("Echo: " + request);

            // Close the connection
            socket.close();
        }
    }
}