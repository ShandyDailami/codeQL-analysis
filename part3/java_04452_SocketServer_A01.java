import java.net.*;
import java.io.*;

public class java_04452_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080;

        // Create a server socket
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept();

                // Create input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String inputLine;
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                // Handle each client separately
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);

                    // Simulate security-sensitive operation
                    // This is a dummy operation, replace it with your actual code
                    String response = "Message received";
                    out.println(response);
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}