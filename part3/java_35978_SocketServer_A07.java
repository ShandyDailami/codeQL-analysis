import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35978_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                if (message.equals("exit")) {
                    out.println("Goodbye!");
                    break;
                }

                // Perform some security-sensitive operation
                // This is a very simple example, in a real-world application,
                // you might want to check the authentication token and perform
                // a more complex operation.
                if (message.equals("authFailure")) {
                    out.println("Authentication failed!");
                    break;
                }

                out.println("Hello, client!");
            }

            clientSocket.close();
        }
    }
}