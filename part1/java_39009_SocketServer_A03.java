import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39009_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String request;
            while ((request = in.readLine()) != null) {
                handleRequest(request, out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(String request, PrintWriter out) {
        // Implement security-sensitive operations related to A03_Injection here.
        // For example: Sanitize input to prevent SQL injection.
        String sanitizedRequest = request.replaceAll(";", "");

        // Send response
        out.println("You said: " + sanitizedRequest);
    }
}