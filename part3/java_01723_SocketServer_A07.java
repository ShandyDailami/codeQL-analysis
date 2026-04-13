import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_01723_SocketServer_A07 {
    private final Socket socket;

    public java_01723_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void handle() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);
                if (input.equals("exit")) {
                    out.println("Exiting...");
                    break;
                } else {
                    // Example of security-sensitive operation
                    String hashedInput = hashInput(input);
                    out.println("Processed: " + hashedInput);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String hashInput(String input) {
        // Implementation of hashing mechanism here
        // This is a placeholder, replace it with your actual implementation
        return "hashedInput";
    }

    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to a port
        Socket serverSocket = new Socket("localhost", 8080);

        // Create a new SocketServer and handle the incoming connection
        SocketServer socketServer = new SocketServer(serverSocket);
        socketServer.handle();
    }
}