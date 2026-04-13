import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38550_SocketServer_A07 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String SHARED_SECRET = "my_secret";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = in.readLine();
                if (!clientMessage.equals(SHARED_SECRET)) {
                    System.out.println("Authentication failed. Closing connection.");
                    clientSocket.close();
                    continue;
                }

                out.println("Authentication successful. Type something...");
                out.flush();

                BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String serverMessage = inputFromClient.readLine();
                System.out.println("Server received: " + serverMessage);

                out.println(serverMessage);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}