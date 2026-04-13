import java.io.*;
import java.net.*;

public class java_37256_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);

        while (true) {
            Socket socket = server.accept();

            // Buffer for reading data from client
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            // Buffer for writing data to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read message from client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Respond to client
            out.println("Hello, client!");
        }
    }
}