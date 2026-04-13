import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24055_SocketServer_A08 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = server.accept();
                System.out.println("Client connected!");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientMsg;
                while ((clientMsg = in.readLine()) != null) {
                    System.out.println("Received: " + clientMsg);

                    // Simulate integrity failure by sending the client's message in reverse order
                    if (clientMsg.equals("A08_IntegrityFailure")) {
                        out.println("Failure! A08_IntegrityFailure");
                        out.flush();
                        break;
                    } else {
                        // Continue processing the request
                        out.println("Processed: " + clientMsg);
                        out.flush();
                    }
                }
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}