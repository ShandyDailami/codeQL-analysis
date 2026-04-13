import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_30542_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a new server socket at port 8080
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(8080);

        while (true) {
            // Accept a new client socket
            Socket clientSocket = serverSocket.accept();

            // Create a new reader from the socket input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a new writer to the socket output stream
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the client's request
            String request = in.readLine();

            // Check if the request is "quit"
            if (request.equals("quit")) {
                // Close the connection
                clientSocket.close();
                continue;
            }

            // Check if the request is too long
            if (request.length() > 1000) {
                // Respond with a 400 error
                out.println("HTTP/1.1 400 Bad Request");
                out.println("Content-Type: text/plain; charset=utf-8");
                out.println();
                out.println("Request is too long!");
                out.flush();
                continue;
            }

            // Check if the request is not secure
            if (!request.startsWith("GET / HTTP/1.1")) {
                // Respond with a 403 error
                out.println("HTTP/1.1 403 Forbidden");
                out.println("Content-Type: text/plain; charset=utf-8");
                out.println();
                out.println("Access Denied!");
                out.flush();
                continue;
            }

            // If everything is okay, respond with a 200 OK
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain; charset=utf-8");
            out.println();
            out.println("Hello, World!");
            out.flush();
        }
    }
}