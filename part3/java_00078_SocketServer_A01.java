import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00078_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received: " + message);

                        if (message.equals("exit")) {
                            break;
                        }

                        // Assume we are sending a welcome message back to the client
                        out.println("Hello, client, thanks for connecting!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}