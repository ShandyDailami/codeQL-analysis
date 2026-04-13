import java.io.*;
import java.net.*;

public class java_17456_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create streams for reading and writing
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request from client
            String request = in.readLine();
            System.out.println("Received request: " + request);

            // Send response back to client
            out.writeBytes("Hello, client!\n");

            // Close streams
            in.close();
            out.close();
            socket.close();
        }
    }
}