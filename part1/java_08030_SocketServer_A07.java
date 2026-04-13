import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_08030_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        // Create a server socket
        int port = 8080;
        System.out.println("Starting server on port " + port);
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

            // Read from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Authentication failure
            if ("fail".equals(message)) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Authentication failure");
                out.flush();
            } else {
                // Authentication success
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Authentication success");
                out.flush();
            }

            clientSocket.close();
        }
    }
}