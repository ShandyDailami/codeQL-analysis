import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_24875_SocketServer_A08 {

    public static void main(String[] args) {
        // Start the server with a fixed port
        int port = 8080;
        System.out.println("Starting server on port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // You can add checks here to ensure data integrity.
                // For example, you might check if the data is in the correct format.

                // For the sake of simplicity, we will just echo back the data.
                out.println("Echo: " + inputLine);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}