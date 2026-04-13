import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_07818_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 8080; // Set the port
        try (Socket serverSocket = new Socket("localhost", port);
             PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()))) {

            System.out.println("Connected to port " + port);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);

                // Simulating a security sensitive operation related to authentication failure
                if ("authFailure".equalsIgnoreCase(inputLine)) {
                    out.println("AuthFailure");
                } else {
                    out.println("Other message");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}