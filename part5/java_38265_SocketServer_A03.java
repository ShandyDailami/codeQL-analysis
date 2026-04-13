import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_38265_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(4444);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Create input and output streams
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    // Echo back the input string
                    out.println("Echo: " + inputLine);

                    // Implementing a security-sensitive operation related to injection
                    // Here, we are simply echoing back the input string
                    // In a real-world scenario, this could be a command execution or data manipulation operation
                    // For example, a command injection or a cross-site scripting (XSS) attack
                    // The above line is a simplification, actual implementation will depend on the specific requirements
                    out.println("Echo: " + inputLine);
                }

                // Close the connection
                out.close();
                in.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}