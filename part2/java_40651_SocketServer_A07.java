import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_40651_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        // Step 1: Create a new socket server.
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(PORT);

        while (true) {
            // Step 2: Accept the client's connection.
            Socket clientSocket = serverSocket.accept();

            // Step 3: Handle the client's request.
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                // Step 4: Process the request (e.g., authenticate the user).
                if ("auth".equals(request)) {
                    out.println("failure"); // In this case, simulate failure of authentication.
                } else {
                    out.println("success"); // In this case, simulate successful authentication.
                }
                out.flush();
            }

            // Close the connection.
            clientSocket.close();
        }
    }
}